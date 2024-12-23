package com.antwika.poker;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder(toBuilder = true)
@Getter
public class State {
    private final boolean ongoing;
    private final String name;
    private final String type;
    private final String stakes;
    private final long handId;
    private final List<Seat> seats;
    private final int cardsPerPlayer;
    private final String communityCards;
    private final List<String> blindNames;
    private final List<Integer> blinds;
    private final List<List<Integer>> pots;
    private final List<String> roundNames;
    private final List<Integer> rounds;
    private final int roundIndex;
    private final int actionAt;
    private final String deck;

    public State(boolean ongoing, String name, String type, String stakes, long handId, List<Seat> seats, int cardsPerPlayer, String communityCards, List<String> blindNames, List<Integer> blinds, List<List<Integer>> pots, List<String> roundNames, List<Integer> rounds, int roundIndex, int actionAt, String deck) {
        this.ongoing = ongoing;
        this.name = name;
        this.type = type;
        this.stakes = stakes;
        this.seats = seats;
        this.handId = handId;
        this.cardsPerPlayer = cardsPerPlayer;
        this.communityCards = communityCards;
        this.blindNames = blindNames;
        this.blinds = blinds;
        this.pots = pots;
        this.roundNames = roundNames;
        this.roundIndex = roundIndex;
        this.rounds = rounds;
        this.actionAt = actionAt;
        this.deck = deck;
    }

    public static int getCommitted(State state, int roundIndex, Seat seat) {
        return getCommitted(state, roundIndex, state.getSeats().indexOf(seat));
    }

    public static int getCommitted(State state, int roundIndex, int seatIndex) {
        return state.getPots().get(roundIndex).get(seatIndex);
    }

    public static int getBiggestBet(State state, int roundIndex) {
        return state.getPots().get(roundIndex).stream()
            .mapToInt(c -> c)
            .max()
            .orElse(0);
    }

    public static boolean isCandidateToWinPot(State state, int seatIndex) {
        final var seat = state.getSeats().get(seatIndex);

        if (seat.getAgentId() == null) return false;
        if (seat.isSitOut()) return false;
        if (seat.isMucked()) return false;
        if (seat.getCards() == null || seat.getCards().isEmpty()) return false;

        return true;
    }

    public static boolean isCandidateToWinPotAndNotAllIn(State state, int seatIndex) {
        if (!isCandidateToWinPot(state, seatIndex)) return false;
        if (!hasMatchedBiggestBetOrIsAllIn(state, state.getRoundIndex(), seatIndex)) return false;

        return true;
    }

    public static boolean hasMatchedBiggestBetOrIsAllIn(State state, int roundIndex, int seatIndex) {
        final var seat = state.getSeats().get(seatIndex);

        if (seat.getStack() == 0) return true;

        final var committed = State.getCommitted(state, roundIndex, seatIndex);
        final var biggestBet = State.getBiggestBet(state, roundIndex);
        if (committed == biggestBet) {
            return seat.isActed();
        } else {
            return false;
        }
    }

    public static boolean isBettingRoundConcluded(State state) {
        int nPlayers = 0;
        int playersActedAndMatchedBet = 0;

        final var biggestBet = State.getBiggestBet(state, state.getRoundIndex());

        for (var seat : state.getSeats()) {
            if (seat.getAgentId() == null) continue;
            if (seat.isSitOut()) continue;
            if (seat.isMucked()) continue;
            if (seat.getCards() == null) continue;
            if (seat.getCards().isEmpty()) continue;

            final var committed = State.getCommitted(state, state.getRoundIndex(), seat);

            final var hasMatchedBet = seat.getStack() == 0 || committed == biggestBet;

            nPlayers += 1;
            if (seat.isActed() && hasMatchedBet) playersActedAndMatchedBet += 1;
        }

        final var nPlayersLeftToAct = nPlayers - playersActedAndMatchedBet;

        return nPlayersLeftToAct == 0;
    }

    public static int getNextActionAt(State state) {
        for (int i = 1; i <= state.getSeats().size(); i++) {
            final var nextSeatIndex = (state.getActionAt() + i) % state.getSeats().size();

            if (!State.isCandidateToWinPot(state, nextSeatIndex)) continue;

            if (State.isCandidateToWinPotAndNotAllIn(state, nextSeatIndex)) continue;
            else {
                return nextSeatIndex;
            }
        }

        final var buttonAt = getButtonAt(state);

        for (int i = 1; i <= state.getSeats().size(); i++) {
            final var nextSeatIndex = (buttonAt + i) % state.getSeats().size();
            final var nextSeat = state.getSeats().get(nextSeatIndex);
            if (nextSeat.getAgentId() == null) continue;
            if (nextSeat.isSitOut()) continue;
            if (nextSeat.isMucked()) continue;
            if (nextSeat.getCards() == null) continue;
            if (nextSeat.getCards().isEmpty()) continue;
            if (nextSeat.getStack() == 0) continue;
            return nextSeatIndex;
        }

        throw new RuntimeException("Could not find next seat to act");
    }

    public static int getButtonAt(State state) {
        for (int i = 0; i < state.getBlinds().size(); i++) {
            if (state.getBlinds().get(i) == 0) return i;
        }
        throw new RuntimeException("Could not find button index");
    }

    public static boolean isShowdown(State state) {
        return state.getRoundIndex() > state.getRounds().size();
    }

    public static Seat getCurrentSeatToAct(State state) {
        return state.getSeats().get(state.getActionAt());
    }

    public static int getSeatIndexOfSeat(State state, Seat seat) {
        return state.getSeats().indexOf(seat);
    }

    public static IAgent getAgentOfSeat(AgentRepository agentRepository, State state, Seat seat) {
        final var agentId = seat.getAgentId();
        return agentRepository.findAgentByUuid(agentId).orElseThrow(() -> new RuntimeException("Could not find agent"));
    }

    public static State collectCardsToDeck(State state) {
        final var stateBuilder = state.toBuilder();

        final var deckBuilder = new StringBuilder(state.getDeck());

        final var seats = new ArrayList<>(List.copyOf(state.getSeats()));

        for (int i = 0; i < state.getSeats().size(); i++) {
            final var seat = seats.get(i);
            final var seatBuilder = seat.toBuilder();
            deckBuilder.append(seat.getCards());
            seatBuilder.cards("");
            seats.set(i, seatBuilder.build());
        }

        stateBuilder.seats(seats);

        deckBuilder.append(state.getCommunityCards());
        stateBuilder.communityCards("");

        stateBuilder.deck(deckBuilder.toString());

        return stateBuilder.build();
    }
}
