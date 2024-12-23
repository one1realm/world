package com.antwika;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Pot {
    public static int[][] groupIndicesByHandStrength(long[] hands) {
        final var map = new TreeMap<Long, List<Integer>>();

        for (int i = 0; i < hands.length; i++) {
            if (hands[i] < 0) continue;
            if (!map.containsKey(hands[i])) {
                map.put(hands[i], new ArrayList<>());
            }
            map.get(hands[i]).add(i);
        }

        final var indicesByHandStrength = new ArrayList<int[]>();

        for (var indices : map.values()) {
            int[] array = indices.stream().mapToInt(Integer::intValue).toArray();
            indicesByHandStrength.add(array);
        }

        return indicesByHandStrength.toArray(new int[0][]);
    }

    public static int[][] computePots(int[] bets) {
        final var pots = new ArrayList<int[]>();

        final var currentBets = Arrays.copyOf(bets, bets.length);

        while (Arrays.stream(currentBets).sum() > 0) {
            final var min = Arrays.stream(currentBets).filter(bet -> bet > 0).min().orElseThrow(() -> new RuntimeException("Could not find the smallest bet!"));
            final var pot = new int[currentBets.length];

            for (int i = 0; i < currentBets.length; i++) {
                final var currentBet = currentBets[i];
                if (currentBet == 0) continue;
                pot[i] += min;
                currentBets[i] -= min;
            }

            pots.add(pot);
        }

        return pots.toArray(int[][]::new);
    }

    public static int[] mergeArrays(int[] a, int[] b) {
        if (a.length != b.length) throw new RuntimeException("Arrays must be equal length to merge");
        final var merged = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i] + b[i];
        }
        return merged;
    }

    public static int[][] collapsePots(int[][] pots) {
        final var collapsedPots = new ArrayList<int[]>();

        if (pots.length == 0) return new int[][]{};

        collapsedPots.add(Arrays.copyOf(pots[0], pots[0].length));

        for (int i = 1; i < pots.length; i++) {
            final var pot = pots[i];
            if (Arrays.stream(pot).sum() == 0) continue;

            final var collapsed = collapsedPots.get(collapsedPots.size() - 1);

            final var signatureA = Arrays.stream(collapsed).map(bet -> bet > 0 ? 1 : 0).toArray();
            final var signatureB = Arrays.stream(pot).map(bet -> bet > 0 ? 1 : 0).toArray();

            if (Arrays.equals(signatureA, signatureB)) {
                collapsedPots.set(collapsedPots.size() - 1, mergeArrays(collapsed, pot));
            } else {
                collapsedPots.add(Arrays.copyOf(pot, pot.length));
            }
        }

        return collapsedPots.toArray(int[][]::new);
    }

    public static int[][] distribute(List<List<Integer>> pots, long[] hands, int beginIndex) {
        final var potsArray = new int[pots.size()][];
        for (int i = 0; i < pots.size(); i++) {
            final var commits = pots.get(i);
            final var commitsArray = new int[commits.size()];
            for (int j = 0; j < commits.size(); j++) {
                final var commit = commits.get(j);
                commitsArray[j] = commit;
            }
            potsArray[i] = commitsArray;
        }
        return distribute(potsArray, hands, beginIndex);
    }

    public static int[][] distribute(int[][] pots, long[] hands, int beginIndex) {
        final var result = new ArrayList<int[]>();
        for (final var pot : pots) result.addAll(distributePot(hands, beginIndex, pot));
        return collapsePots(result.toArray(int[][]::new));
    }

    public static List<int[]> distributePot(long[] hands, int beginIndex, int[] pot) {
        final var handIndicesGroupedByStrength = groupIndicesByHandStrength(hands);

        var wins = new int[hands.length];

        final var result = new ArrayList<int[]>();

        for (var i = handIndicesGroupedByStrength.length - 1; i >= 0; i--) {
            final var remaining = Arrays.stream(pot).sum() - Arrays.stream(wins).sum();

            if (remaining == 0) break;

            final var handIndicesGroup = Arrays.stream(handIndicesGroupedByStrength[i])
                .filter(handIndex -> pot[handIndex] > 0)
                .toArray();

            if (handIndicesGroup.length == 0) continue;

            final var shares = distributeRest(hands, handIndicesGroup, beginIndex, remaining);
            wins = mergeArrays(wins, shares);

            result.add(wins);
        }

        return result;
    }

    public static int[] distributeRest(long[] hands, int[] winnerIndices, int beginIndex, int rest) {
        final var winners = new int[hands.length];

        for (int j = 0; rest > 0; j++) {
            int wrappedHandIndex = (beginIndex + j) % hands.length;

            var isAWinner = false;
            for (int k : winnerIndices) {
                if (k == wrappedHandIndex) {
                    isAWinner = true;
                    break;
                }
            }

            if (isAWinner) {
                winners[wrappedHandIndex] += 1;
                rest -= 1;
            }
        }

        return winners;
    }
}
