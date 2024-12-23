package com.antwika.poker;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DeckTest {
    @Test
    public void shuffle() {
        final var mockRandom = mock(Random.class);
        when(mockRandom.nextInt(4)).thenReturn(1);
        when(mockRandom.nextInt(3)).thenReturn(2);
        when(mockRandom.nextInt(2)).thenReturn(1);
        when(mockRandom.nextInt(1)).thenReturn(0);
        assertEquals("3d5s4h2c", Deck.shuffle(mockRandom, "2c3d4h5s"));
    }
}
