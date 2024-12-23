package com.antwika;

import com.antwika.poker.AgentRepository;
import com.antwika.poker.State;
import com.antwika.state.SeatState;
import com.antwika.state.TableState;

import java.util.Arrays;
import java.util.Random;

public class Poker {
    public static TableState createTable(Random random, String stakes, int seatCount) {
        final var seats = new SeatState[seatCount];

        for (int i = 0; i < seatCount; i++) {
            seats[i] = SeatState.builder().build();
        }

        final var buttonAt = random.nextInt(seatCount);

        final var blinds = new int[seatCount];
        Arrays.fill(blinds, -1);
        blinds[buttonAt] = 0;
        blinds[(buttonAt + 1) % blinds.length] = 2;

        return TableState.builder()
            .tableName("OneRealm Poker")
            .stakes(stakes)
            .communityCards("")
            .pot(new int[][]{})
            .seats(seats)
            .buttonAt(buttonAt)
            .blinds(blinds)
            .build();
    }

    public static TableState playerJoin(PlayerRepository playerRepository, TableState tableState, int seatIndex, String playerName, int chips) {
        final var seats = Arrays.copyOf(tableState.getSeats(), tableState.getSeats().length);

        if (seatIndex < 0) throw new RuntimeException("Seat index out of bounds!");
        if (seatIndex >= seats.length) throw new RuntimeException("Seat index out of bounds!");

        final var player = playerRepository.findByPlayerName(playerName).orElseThrow(() -> new RuntimeException("Player could not be found!"));

        if (seats[seatIndex].getPlayerName() == null) {
            seats[seatIndex] = SeatState.builder()
                .playerName(player.getPlayerName())
                .chips(chips)
                .missedSmallBlind(true)
                .missedBigBlind(true)
                .build();
            tableState = tableState.toBuilder().seats(seats).build();
            System.out.printf("Player \"%s\" joined with %d chips%n", tableState.getSeats()[seatIndex].getPlayerName(), tableState.getSeats()[seatIndex].getChips());
        }

        return tableState;
    }

    public static TableState playerLeave(TableState tableState, int seatIndex) {
        final var seats = Arrays.copyOf(tableState.getSeats(), tableState.getSeats().length);
        seats[seatIndex] = SeatState.builder().build();
        return tableState.toBuilder().seats(seats).build();
    }

    public static int[] getPlayersWantingToPlay(TableState tableState) {
        final var players = new int[tableState.getSeats().length];
        Arrays.fill(players, 0);
        for (int i = 0; i < tableState.getSeats().length; i++) {
            final var seat = tableState.getSeats()[i];
            final var playerName = seat.getPlayerName();
            if (playerName != null) {
                // TODO: Don't just assume that players want to post.
                players[i] = 1;
            }
        }
        return players;
    }

    public static int[] computePositions(AgentRepository agentRepository, State state) {
        int[] players = new int[state.getSeats().size()];
        Arrays.fill(players, 0);

        /*final var blindAmounts = Arrays.stream(state.getStakes().split("/")).map(Integer::parseInt).toList();

        for (int blindIndex = 0; blindIndex < blindAmounts.size(); blindIndex++) {
            final var blindAmount = blindAmounts.get(blindIndex);
        }*/

        for (int i = 0; i < state.getSeats().size(); i++) {
            final var seat = state.getSeats().get(i);
            final var agentId = seat.getAgentId();
            if (agentId != null) {
                final var agent = agentRepository.findAgentByUuid(agentId).orElseThrow(() -> new RuntimeException("Player not found"));
                if (seat.isSitOut()) continue;
                if (seat.getStack() <= 0) continue;
                players[i] = 1;
            }
        }

        final var stakes = state.getStakes();
        final var blinds = state.getBlinds().stream().mapToInt(Integer::intValue).toArray();
        final var computed = computePositions(stakes, players, blinds);
        return computed;
    }

    public static int[] computePositions(TableState tableState) {
        return computePositions(tableState.getStakes(), getPlayersWantingToPlay(tableState), tableState.getBlinds());
    }

    /**
     * @param stakes             A delimited string that denotes the blinds of the game, e.g. "100/200/400", is a three blind game, where small blind is 100, big blind is 200, and first straddle is 400.
     * @param players            An integer array, where each element represents a position in the game, an element value denotes whether the player at that position wants to play in this hand.
     * @param lastBlindPositions An integer array, where each element represents a position in the game, an element value denotes which blind index was posted in the last hand.
     * @return A new integer array, where each element represents a position in the game, an element value denotes which blind index needs to be posted, e.g., value zero is the button, value one is the small blind, value two is the big blind, value three is the first straddle.
     */
    public static int[] computePositions(String stakes, int[] players, int[] lastBlindPositions) {
        final var nPlayers = Arrays.stream(players).filter(p -> p == 1).count();

        if (nPlayers < 2) throw new RuntimeException("Too few players");

        final var nBlinds = (int) Math.min(nPlayers, stakes.split("/").length);

        if (nBlinds < 2) throw new RuntimeException("Too few blinds");

        final var nextBlindPositions = new int[lastBlindPositions.length];
        Arrays.fill(nextBlindPositions, -1);

        final var blindLastAt = new int[nBlinds + 1];
        Arrays.fill(blindLastAt, -1);

        for (int i = 0; i < lastBlindPositions.length; i++) {
            if (lastBlindPositions[i] >= 0) blindLastAt[lastBlindPositions[i]] = i;
        }

        // If there was no small blind posted last hand, then the button stays in place.
        if (blindLastAt[1] == -1) {
            nextBlindPositions[blindLastAt[0]] = 0;
        }

        // If there was a small blind posted last hand, then the button moves to that position.
        if (blindLastAt[1] != -1) {
            nextBlindPositions[blindLastAt[1]] = 0;
        }

        // The player who posted big blind last hand, is now small blind.
        if (blindLastAt[2] != -1) {
            if (players[blindLastAt[2]] == 1) {
                nextBlindPositions[blindLastAt[2]] = 1;
            }
        }

        // Determine next big blind and following straddles.
        for (int blindIndex = 2; blindIndex <= nBlinds; blindIndex++) {
            for (int i = 1; i < nextBlindPositions.length; i++) {
                final var blindNowAt = (blindLastAt[blindIndex] + i) % nextBlindPositions.length;
                if (players[blindNowAt] == 1) {
                    nextBlindPositions[blindNowAt] = blindIndex;
                    break;
                }
            }
        }

        return nextBlindPositions;
    }

    public static TableState startHand(PlayerRepository playerRepository, TableState tableState, Random random) {
        tableState = tableState.toBuilder().handId(tableState.getHandId() + 1).build(); // Increment hand id
        tableState = tableState.toBuilder().blinds(computePositions(tableState)).build(); // Compute blinds

        // TODO: Post blinds accordingly to tableState.getBlinds()...
        // TODO: Reset missed blinds for big blind seat...
        // TODO: Post all missed blinds...
        // TODO: Deal hole cards
        // TODO: ...

        System.out.printf("Hand started%n");
        return tableState;
    }
}
