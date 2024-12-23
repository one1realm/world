package com.antwika;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PotTest {
    @Test
    public void temp() {
        final var pots = List.of( // Pre-flop
            List.of( // Side pots
                List.of(0, 10, 10, 0), // Main pot
                List.of(0, 0, 10, 0) // Side pot #1
            )
        );


        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 0, 10}
        }, Pot.computePots(new int[]{10, 10, 20}));
    }

    @Test
    public void groupIndicesByHandStrength_case0() {
        assertArrayEquals(new int[][]{
            new int[]{0, 1, 2}
        }, Pot.groupIndicesByHandStrength(new long[]{1, 1, 1}));
    }

    @Test
    public void groupIndicesByHandStrength_case1() {
        assertArrayEquals(new int[][]{
            new int[]{0, 1},
            new int[]{2}
        }, Pot.groupIndicesByHandStrength(new long[]{1, 1, 2}));
    }

    @Test
    public void groupIndicesByHandStrength_case2() {
        assertArrayEquals(new int[][]{
            new int[]{0},
            new int[]{1, 2}
        }, Pot.groupIndicesByHandStrength(new long[]{1, 2, 2}));
    }

    @Test
    public void groupIndicesByHandStrength_case3() {
        assertArrayEquals(new int[][]{
            new int[]{0},
            new int[]{1},
            new int[]{2}
        }, Pot.groupIndicesByHandStrength(new long[]{1, 2, 3}));
    }

    @Test
    public void groupIndicesByHandStrength_case4() {
        assertArrayEquals(new int[][]{
            new int[]{2},
            new int[]{1},
            new int[]{0}
        }, Pot.groupIndicesByHandStrength(new long[]{3, 2, 1}));
    }

    @Test
    public void groupIndicesByHandStrength_case5() {
        assertArrayEquals(new int[][]{
            new int[]{0, 2},
            new int[]{1}
        }, Pot.groupIndicesByHandStrength(new long[]{1, 2, 1}));
    }

    @Test
    public void bets_case0() {
        assertArrayEquals(new int[][]{}, Pot.computePots(new int[]{}));
    }

    @Test
    public void bets_case1() {
        assertArrayEquals(new int[][]{}, Pot.computePots(new int[]{0}));
    }

    @Test
    public void bets_case2() {
        assertArrayEquals(new int[][]{
            new int[]{10}
        }, Pot.computePots(new int[]{10}));
    }

    @Test
    public void bets_case3() {
        assertArrayEquals(new int[][]{}, Pot.computePots(new int[]{0, 0}));
    }

    @Test
    public void bets_case4() {
        assertArrayEquals(new int[][]{
            new int[]{0, 10}
        }, Pot.computePots(new int[]{0, 10}));
    }

    @Test
    public void bets_case5() {
        assertArrayEquals(new int[][]{
            new int[]{10, 0}
        }, Pot.computePots(new int[]{10, 0}));
    }

    @Test
    public void bets_case6() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10}
        }, Pot.computePots(new int[]{10, 10}));
    }

    @Test
    public void bets_case7() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10},
            new int[]{0, 10}
        }, Pot.computePots(new int[]{10, 20}));
    }

    @Test
    public void bets_case8() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10},
            new int[]{10, 0}
        }, Pot.computePots(new int[]{20, 10}));
    }

    @Test
    public void bets_case9() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 0, 10}
        }, Pot.computePots(new int[]{10, 10, 20}));
    }

    @Test
    public void bets_case10() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10}
        }, Pot.computePots(new int[]{10, 20, 20}));
    }

    @Test
    public void bets_case11() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        }, Pot.computePots(new int[]{10, 20, 30}));
    }

    @Test
    public void bets_case12() {
        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10},
            new int[]{10, 10, 0},
            new int[]{10, 0, 0}
        }, Pot.computePots(new int[]{30, 20, 10}));
    }

    @Test
    public void collapsePots_case0() {
        final var pots = new int[][]{
            new int[]{10, 10, 10, 10},
            new int[]{10, 10, 10, 0},
            new int[]{5, 5, 5, 0},
            new int[]{3, 3, 0, 0},
            new int[]{1, 1, 0, 0},
            new int[]{0, 0, 0, 0},
            new int[]{0, 0, 0, 0},
        };

        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10, 10},
            new int[]{15, 15, 15, 0},
            new int[]{4, 4, 0, 0},
        }, Pot.collapsePots(pots));
    }

    @Test
    public void distribute_case0() {
        final var hands = new long[]{1, 1, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case1() {
        final var hands = new long[]{1, 1, 2};
        final var pots = new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{0, 0, 60}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case2() {
        final var hands = new long[]{1, 2, 2};
        final var pots = new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{0, 25, 25},
            new int[]{0, 0, 10}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case3() {
        final var hands = new long[]{1, 2, 3};
        final var pots = new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{0, 0, 60}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case4() {
        final var hands = new long[]{3, 2, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{30, 0, 0},
            new int[]{0, 20, 0},
            new int[]{0, 0, 10}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case5() {
        final var hands = new long[]{1, 2, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10},
            new int[]{0, 10, 10},
            new int[]{0, 0, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{0, 50, 0},
            new int[]{0, 0, 10}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case6() {
        final var hands = new long[]{1, 1, -1, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{14, 13, 0, 13}
        }, Pot.distribute(pots, hands, 0));
    }

    @Test
    public void distribute_case7() {
        final var hands = new long[]{1, 1, -1, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{13, 14, 0, 13}
        }, Pot.distribute(pots, hands, 1));
    }

    @Test
    public void distribute_case8() {
        final var hands = new long[]{1, 1, -1, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{13, 13, 0, 14}
        }, Pot.distribute(pots, hands, 2));
    }

    @Test
    public void distribute_case9() {
        final var hands = new long[]{1, 1, -1, 1};
        final var pots = new int[][]{
            new int[]{10, 10, 10, 10}
        };

        assertArrayEquals(new int[][]{
            new int[]{13, 13, 0, 14}
        }, Pot.distribute(pots, hands, 3));
    }

    @Test
    public void multipleStreets_case0() {
        final var prePots = Pot.computePots(new int[]{1, 2, 2, 2});
        final var flopPots = Pot.computePots(new int[]{0, 7, 7, 2});
        final var turnPots = Pot.computePots(new int[]{0, 16, 16, 0});
        final var riverPots = Pot.computePots(new int[]{0, 0, 0, 0});

        final var allPots = new ArrayList<int[]>();

        allPots.addAll(Arrays.asList(prePots));
        allPots.addAll(Arrays.asList(flopPots));
        allPots.addAll(Arrays.asList(turnPots));
        allPots.addAll(Arrays.asList(riverPots));

        assertArrayEquals(new int[][]{
            new int[]{0, 55, 0, 0}
        }, Pot.distribute(allPots.toArray(int[][]::new), new long[]{0, 1, 0, 0}, 0));
    }

    @Test
    public void multipleStreets_case1() {
        final var prePots = Pot.computePots(new int[]{1, 2, 2, 2});
        final var flopPots = Pot.computePots(new int[]{0, 7, 7, 2});
        final var turnPots = Pot.computePots(new int[]{0, 16, 16, 0});
        final var riverPots = Pot.computePots(new int[]{0, 0, 0, 0});

        final var allPots = new ArrayList<int[]>();

        allPots.addAll(Arrays.asList(prePots));
        allPots.addAll(Arrays.asList(flopPots));
        allPots.addAll(Arrays.asList(turnPots));
        allPots.addAll(Arrays.asList(riverPots));

        assertArrayEquals(new int[][]{
            new int[]{0, 28, 27, 0},
        }, Pot.distribute(allPots.toArray(int[][]::new), new long[]{0, 1, 1, 0}, 0));
    }

    @Test
    public void multipleStreets_case2() {
        final var prePots = Pot.computePots(new int[]{1, 2, 2, 2});
        final var flopPots = Pot.computePots(new int[]{0, 7, 7, 2});
        final var turnPots = Pot.computePots(new int[]{0, 16, 16, 0});
        final var riverPots = Pot.computePots(new int[]{0, 0, 0, 0});

        final var allPots = new ArrayList<int[]>();

        allPots.addAll(Arrays.asList(prePots));
        allPots.addAll(Arrays.asList(flopPots));
        allPots.addAll(Arrays.asList(turnPots));
        allPots.addAll(Arrays.asList(riverPots));

        assertArrayEquals(new int[][]{
            new int[]{0, 27, 28, 0},
        }, Pot.distribute(allPots.toArray(int[][]::new), new long[]{0, 1, 1, 0}, 2));
    }
}
