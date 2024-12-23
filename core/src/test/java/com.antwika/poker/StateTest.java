package com.antwika.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StateTest {
    @Test
    public void getCommitted() {
        final var mockState = mock(State.class);
        when(mockState.getPots()).thenReturn(
            List.of(
                List.of(0, 10, 20) // Pre-flop
            )
        );

        assertEquals(0, State.getCommitted(mockState, 0, 0));
        assertEquals(10, State.getCommitted(mockState, 0, 1));
        assertEquals(20, State.getCommitted(mockState, 0, 2));
    }

    @Test
    public void getBiggestBet() {
        final var mockState = mock(State.class);
        when(mockState.getPots()).thenReturn(
            List.of(
                List.of(0, 10, 20) // Pre-flop
            )
        );

        assertEquals(20, State.getBiggestBet(mockState, 0));
    }
}
