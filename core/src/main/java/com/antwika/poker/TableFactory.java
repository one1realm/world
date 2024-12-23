package com.antwika.poker;

import java.util.List;

public class TableFactory {
    public static Table createTexasHoldemTable(AgentRepository agentRepository) {
        final var table = new Table(agentRepository,
            List.of( // States history
                new State(false,
                    "Aberlour",
                    "Hold'em No Limit",
                    "10/20",
                    0L,
                    List.of(
                        new Seat(null, "", -1, false, false, false, List.of()),
                        new Seat(null, "", -1, false, false, false, List.of()),
                        new Seat(null, "", -1, false, false, false, List.of()),
                        new Seat(null, "", -1, false, false, false, List.of())
                    ),
                    2,
                    "",
                    List.of("Button", "Small blind", "Big blind"),
                    List.of(1, 2, -1, 0),
                    List.of(
                        List.of(0, 0, 0, 0)
                    ),
                    List.of("Flop", "Turn", "River"),
                    List.of(3, 1, 1),
                    0,
                    3,
                    "2c3c4c5c6c7c8c9cTcJcQcKcAc2d3d4d5d6d7d8d9dTdJdQdKdAd2h3h4h5h6h7h8h9hThJhQhKhAh2s3s4s5s6s7s8s9sTsJsQsKsAs"
                )
            )
        );
        final var state = table.getStates().get(table.getStates().size() - 1);
        System.out.printf("Table \"%s\" %s %d-max created%n", state.getName(), state.getStakes(), state.getSeats().size());
        return table;
    }
}
