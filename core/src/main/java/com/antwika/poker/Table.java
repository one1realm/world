package com.antwika.poker;

import com.antwika.Hand;
import com.antwika.Poker;
import com.antwika.Pot;
import com.antwika.Util;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class Table {
    private final AgentRepository agentRepository;
    private final List<State> states;

    public Table(AgentRepository agentRepository, List<State> states) {
        this.agentRepository = agentRepository;
        this.states = new ArrayList<>(List.copyOf(states));
    }

    public static void join(AgentRepository agentRepository, Table table, int seatIndex, UUID agentId, int stack) {
        final var state = table.getStates().get(table.getStates().size() - 1);
        final var stateBuilder = state.toBuilder();
        final var seats = new ArrayList<>(List.copyOf(state.getSeats()));
        final var seat = seats.get(seatIndex);
        final var seatBuilder = seat.toBuilder();
        seatBuilder.agentId(agentId);
        seatBuilder.stack(stack);
        seats.set(seatIndex, seatBuilder.build());
        stateBuilder.seats(seats);
        table.getStates().add(stateBuilder.build());

        final var agent = agentRepository.findAgentByUuid(agentId).orElseThrow(() -> new RuntimeException("Player not found"));
        System.out.printf("%s joins table, stack: %d%n", agent.getName(), stack);
    }

    public static void handBegin(AgentRepository agentRepository, Table table) {
        {
            var state = table.getStates().get(table.getStates().size() - 1);

            state = State.collectCardsToDeck(state);

            final var stateBuilder = state.toBuilder();

            stateBuilder.handId(state.getHandId() + 1);
            stateBuilder.ongoing(true);
            stateBuilder.roundIndex(0);
            stateBuilder.pots(List.of(Util.newPrefilledList(state.getSeats().size(), 0)));

            table.getStates().add(stateBuilder.build());
        }

        updateBlinds(agentRepository, table);
        forceBlinds(agentRepository, table);
        dealCards(agentRepository, table);

        final var state = table.getStates().get(table.getStates().size() - 1);
        System.out.printf("One realm Hand #%d:  %s (%s)%n", state.getHandId(), state.getType(), state.getStakes());
        System.out.printf("Table '%s' %d-max (Play Money) Seat #%d is the button%n", state.getName(), state.getSeats().size(), State.getButtonAt(state));

        for (int i = 0; i < state.getSeats().size(); i++) {
            final var seat = state.getSeats().get(i);
            if (seat.getAgentId() == null) continue;
            final var agent = agentRepository.findAgentByUuid(seat.getAgentId()).orElseThrow(() -> new RuntimeException("Player not found"));
            System.out.printf("Seat %d: %s (%d in chips)%n", i + 1, agent.getName(), seat.getStack());
        }

        for (int i = 0; i < state.getBlinds().size(); i++) {
            final var seat = state.getSeats().get(i);
            final var blindIndex = state.getBlinds().get(i);
            if (blindIndex > 0) {
                final var blindName = state.getBlindNames().get(blindIndex);
                final var blindAmount = Integer.parseInt(state.getStakes().split("/")[blindIndex - 1]);
                final var agent = agentRepository.findAgentByUuid(seat.getAgentId()).orElseThrow(() -> new RuntimeException("Player not found"));
                System.out.printf("%s: posts %s %d%n", agent.getName(), blindName.toLowerCase(), blindAmount);
            }
        }
    }

    public static void updateBlinds(AgentRepository agentRepository, Table table) {
        final var state = table.getStates().get(table.getStates().size() - 1);
        final var blinds = Poker.computePositions(agentRepository, table.getStates().get(table.getStates().size() - 1));
        final var stateBuilder = state.toBuilder();
        final var newBlinds = Arrays.stream(blinds).boxed().collect(Collectors.toList());
        stateBuilder.blinds(newBlinds);

        /*for (int i = 0; i < newBlinds.size(); i++) {
            if (newBlinds.get(0) == 0) stateBuilder.
        }*/

        table.getStates().add(stateBuilder.build());
    }

    public static void forceBlinds(AgentRepository agentRepository, Table table) {
        final var state = table.getStates().get(table.getStates().size() - 1);
        final var blindAmounts = state.getStakes().split("/");
        for (int blindIndex = 1; blindIndex <= blindAmounts.length; blindIndex++) {
            final var amount = Integer.parseInt(blindAmounts[blindIndex - 1]);
            for (int seatIndex = 0; seatIndex < state.getBlinds().size(); seatIndex++) {
                final var blind = state.getBlinds().get(seatIndex);
                if (blind == blindIndex) {
                    Table.post(agentRepository, table, seatIndex, blindIndex, amount);
                }
            }
        }
    }

    public static void dealCards(AgentRepository agentRepository, Table table) {
        final var fixedCards = List.of("3c", "4c", "5c", "2c", "3d", "4d", "5d", "2d");
        final var state = table.getStates().get(table.getStates().size() - 1);
        final var seats = state.getSeats();

        for (int i = 0; i < seats.size() * state.getCardsPerPlayer(); i++) {
            final var wrapped = (i + 1) % seats.size();
            final var card = fixedCards.get(i);
            Table.deal(agentRepository, table, wrapped, card);
        }
    }

    public static void post(AgentRepository agentRepository, Table table, int seatIndex, int blindIndex, int amount) {
        final var state = table.getStates().get(table.getStates().size() - 1);
        final var stateBuilder = state.toBuilder();
        final var seats = new ArrayList<>(List.copyOf(state.getSeats()));
        final var seat = seats.get(seatIndex);
        final var seatBuilder = seat.toBuilder();
        seatBuilder.stack(seat.getStack() - amount);
        seats.set(seatIndex, seatBuilder.build());
        stateBuilder.seats(seats);

        final var pots = new ArrayList<>(List.copyOf(state.getPots()));
        final var commits = new ArrayList<>(List.copyOf(pots.get(0)));
        commits.set(seatIndex, amount);
        pots.set(0, commits);
        stateBuilder.pots(pots);

        final var blinds = new ArrayList<>(List.copyOf(state.getBlinds()));
        blinds.set(seatIndex, blindIndex);
        stateBuilder.blinds(blinds);

        table.getStates().add(stateBuilder.build());
    }

    public static void deal(AgentRepository agentRepository, Table table, int seatIndex, String cards) {
        final var state = table.getStates().get(table.getStates().size() - 1);
        final var stateBuilder = state.toBuilder();
        final var seats = new ArrayList<>(List.copyOf(state.getSeats()));
        final var seat = seats.get(seatIndex);
        final var seatBuilder = seat.toBuilder();
        seatBuilder.cards(seat.getCards() + cards);
        seats.set(seatIndex, seatBuilder.build());
        stateBuilder.seats(seats);
        table.getStates().add(stateBuilder.build());

        final var agent = agentRepository.findAgentByUuid(seat.getAgentId()).orElseThrow(() -> new RuntimeException("Player not found"));
        //System.out.printf("Dealt %s to %s%n", cards, agent.getName());
    }

    private static State resetSeatActions(State state) {
        final var newStateBuilder = state.toBuilder();

        final var seats = new ArrayList<>(List.copyOf(state.getSeats()));

        for (int i = 0; i < seats.size(); i++) {
            final var s = seats.get(i);

            final var newSeatBuilder = s.toBuilder();
            newSeatBuilder.acted(false);
            seats.set(i, newSeatBuilder.build());
        }

        newStateBuilder.seats(seats);

        return newStateBuilder.build();
    }

    private static State dealCommunityCards(State state) {
        final var newStateBuilder = state.toBuilder();

        if (state.getRoundIndex() < state.getRounds().size()) {
            final var fixedCards = List.of("7s", "8s", "9s", "Ts", "Js");

            final var nCards = state.getRounds().get(state.getRoundIndex());

            var newCards = "";
            for (int i = 0; i < nCards; i++) {
                int cardIndex = state.getCommunityCards().length() / 2 + i;
                newCards += fixedCards.get(cardIndex);
            }
            final var communityCards = state.getCommunityCards() + newCards;
            newStateBuilder.communityCards(communityCards);

            final var roundName = state.getRoundNames().get(state.getRoundIndex());
            System.out.printf("*** %s *** [%s]%n", roundName.toUpperCase(), Hand.toSpacedNotation(communityCards));

            if (state.getCommunityCards().isEmpty()) { // Deal FLOP
                newStateBuilder.communityCards(state.getCommunityCards() + "7s8s9s");
            }
            if (state.getCommunityCards().length() == 2 * 3) { // Deal TURN
                newStateBuilder.communityCards(state.getCommunityCards() + "Ts");
            }
            if (state.getCommunityCards().length() == 2 * 4) { // Deal RIVER
                newStateBuilder.communityCards(state.getCommunityCards() + "Js");
            }
        }

        return newStateBuilder.build();
    }

    private static State collectCommittedChips(State state) {
        final var newStateBuilder = state.toBuilder();
        final var pots = new ArrayList<>(state.getPots());
        final var commits = new int[state.getSeats().size()];
        Arrays.fill(commits, 0);
        pots.add(Arrays.stream(commits).boxed().toList());
        newStateBuilder.pots(pots);
        return newStateBuilder.build();
    }

    private static State moveActionToNextPlayer(State state) {
        var newStateBuilder = state.toBuilder();
        newStateBuilder.actionAt(State.getNextActionAt(state));
        return newStateBuilder.build();
    }

    private static State incrementRoundIndex(State state) {
        final var stateBuilder = state.toBuilder();
        stateBuilder.roundIndex(state.getRoundIndex() + 1);
        return stateBuilder.build();
    }

    private static State deliverPots(AgentRepository agentRepository, State state) {
        final var newStateBuilder = state.toBuilder();

        final var seats = new ArrayList<>(List.copyOf(state.getSeats()));

        final var pots = state.getPots();
        final var beginIndex = (State.getButtonAt(state) + 1) % state.getSeats().size();

        final long[] handValues = seats.stream()
            .map(s -> {
                final var fullHandNotation = state.getCommunityCards() + s.getCards();
                return Hand.valueFromHand(Hand.toHand(fullHandNotation));
            })
            .mapToLong(Long::longValue)
            .toArray();

        final var winnings = Pot.distribute(pots, handValues, beginIndex);

        var totalPot = 0;

        final var winningsBySeatIndex = new int[seats.size()];
        Arrays.fill(winningsBySeatIndex, 0);

        for (var wins : winnings) {
            totalPot += Arrays.stream(wins).sum();

            for (int i = 0; i < wins.length; i++) {
                final var win = wins[i];
                winningsBySeatIndex[i] += win;
                final var winningSeat = seats.get(i);
                final var updatedWinningSeat = winningSeat.toBuilder().stack(winningSeat.getStack() + win).build();
                seats.set(i, updatedWinningSeat);
            }
        }

        newStateBuilder.seats(seats);

        final var emptyPot = new ArrayList<Integer>();
        for (int i = 0; i < seats.size(); i++) {
            emptyPot.add(0);
        }

        newStateBuilder.pots(List.of(emptyPot));

        System.out.printf("*** SUMMARY ***%n");
        System.out.printf("Total pot %d | Rake 0%n", totalPot);
        System.out.printf("Board [%s]%n", Hand.toSpacedNotation(state.getCommunityCards()));

        for (int i = 0; i < state.getSeats().size(); i++) {
            final var localSeat = state.getSeats().get(i);
            final var localAgent = agentRepository.findAgentByUuid(localSeat.getAgentId());
            final var blindIndex = state.getBlinds().get(i);

            final var sb = new StringBuilder();

            if (localAgent.isPresent()) {
                sb.append(String.format("Seat %d: %s ", i, localAgent.get().getName()));

                if (blindIndex >= 0 && blindIndex < state.getBlinds().size()) {
                    final var blind = state.getBlinds().get(blindIndex);
                    if (blind >= 0) {
                        final var blindName = state.getBlindNames().get(state.getBlinds().get(blindIndex));
                        sb.append(String.format("(%s) ", blindName.toLowerCase()));
                    }
                }

                if (localSeat.isMucked()) {
                    sb.append(String.format("mucked [%s] ", Hand.toSpacedNotation(localSeat.getCards())));
                } else {
                    sb.append(String.format("showed [%s] ", Hand.toSpacedNotation(localSeat.getCards())));
                }
                sb.append(String.format("and won (%d)%n", winningsBySeatIndex[i]));
                System.out.print(sb);
            }
        }

        newStateBuilder.ongoing(false);

        return newStateBuilder.build();
    }

    private static State promptAndHandlePlayerAction(AgentRepository agentRepository, State state) {
        final var seat = State.getCurrentSeatToAct(state);
        final var seatIndex = State.getSeatIndexOfSeat(state, seat);
        final var stack = seat.getStack();
        final var agent = State.getAgentOfSeat(agentRepository, state, seat);

        final var roundIndex = state.getRoundIndex();
        final var biggestBet = State.getBiggestBet(state, roundIndex);
        final var committed = State.getCommitted(state, roundIndex, seatIndex);
        final var diff = biggestBet - committed;
        final var commitMin = Math.min(diff, stack);
        final var commitMax = stack;

        final var commit = agent.prompt(state, commitMin, commitMax);

        if (stack < commit)
            throw new RuntimeException(String.format("%s can not bet more than their stack!", agent.getName()));

        final var mutableSeats = new ArrayList<>(List.copyOf(state.getSeats()));
        final var seatBuilder = mutableSeats.get(seatIndex).toBuilder();

        // TODO: Update seat "mucked"
        if (commit < commitMin) {
            seatBuilder.mucked(true);
            System.out.printf("%s: folds%n", agent.getName());
        } else if (commit == 0) {
            System.out.printf("%s: checks%n", agent.getName());
        } else if (commit == commitMin) {
            System.out.printf("%s: calls: %d%n", agent.getName(), commit);
        } else {
            System.out.printf("%s: bets: %d%n", agent.getName(), commit);
        }

        // TODO: Update seat "acted"
        seatBuilder.acted(true);

        // TODO: Deduct commit amount from seat stack
        if (commit > 0) seatBuilder.stack(stack - commit);

        final var stateBuilder = state.toBuilder();

        // TODO: Update seats array
        mutableSeats.set(seatIndex, seatBuilder.build());
        stateBuilder.seats(mutableSeats);

        // TODO: Update pots
        if (commit > 0) {
            final var pots = new ArrayList<>(List.copyOf(state.getPots()));
            final var commits = new ArrayList<>(List.copyOf(pots.get(roundIndex)));
            commits.set(seatIndex, commits.get(seatIndex) + commit);
            pots.set(roundIndex, commits);
            stateBuilder.pots(pots);
        }

        return stateBuilder.build();
    }

    public void progress(int nHands) {
        for (int i = 0; i < nHands; i++) {
            System.out.println("==========================");
            Table.handBegin(agentRepository, this);

            while (true) {
                final var state = getStates().get(getStates().size() - 1);
                if (!state.isOngoing()) break;
                progress();
            }
        }
    }

    public void progress() {
        var state = states.get(states.size() - 1);

        state = promptAndHandlePlayerAction(agentRepository, state);
        state = moveActionToNextPlayer(state);

        if (State.isBettingRoundConcluded(state)) {
            state = collectCommittedChips(state);
            state = dealCommunityCards(state);
            state = incrementRoundIndex(state);
            state = resetSeatActions(state);

            if (State.isShowdown(state)) {
                state = deliverPots(agentRepository, state);
            }
        }

        // Add new state
        states.add(state);
    }
}
