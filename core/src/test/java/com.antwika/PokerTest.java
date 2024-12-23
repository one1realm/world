package com.antwika;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PokerTest {
    @Test
    public void computePositions() {
        assertArrayEquals(new int[]{-1, 0, 1, 2}, Poker.computePositions("1/2", new int[]{1, 1, 1, 1}, new int[]{0, 1, 2, -1}));
        assertArrayEquals(new int[]{0, 1, 2, -1}, Poker.computePositions("1/2", new int[]{1, 1, 1, 1}, new int[]{0, 2, -1, -1}));
        assertArrayEquals(new int[]{2, 0, 1, -1}, Poker.computePositions("1/2", new int[]{1, 1, 1, 0}, new int[]{0, 1, 2, -1}));
        assertArrayEquals(new int[]{0, 1, 2, -1}, Poker.computePositions("1/2", new int[]{1, 1, 1, 0}, new int[]{0, 2, -1, -1}));
        assertArrayEquals(new int[]{0, 1, -1, 2}, Poker.computePositions("1/2", new int[]{1, 1, 0, 1}, new int[]{0, 2, -1, -1}));
        assertArrayEquals(new int[]{0, -1, 2, -1}, Poker.computePositions("1/2", new int[]{1, 0, 1, 1}, new int[]{0, 2, -1, -1}));
        assertArrayEquals(new int[]{3, 0, 1, 2}, Poker.computePositions("1/2/4", new int[]{1, 1, 1, 1}, new int[]{0, 1, 2, 3}));
        assertArrayEquals(new int[]{2, 1, -1, -1}, Poker.computePositions("1/2", new int[]{1, 1, 0, 0}, new int[]{1, 2, -1, -1}));
        assertArrayEquals(new int[]{1, 2, -1, -1}, Poker.computePositions("1/2", new int[]{1, 1, 0, 0}, new int[]{2, 1, -1, -1}));
        assertArrayEquals(new int[]{2, 1, -1, -1}, Poker.computePositions("1/2", new int[]{1, 1, 0, 0}, new int[]{0, 2, -1, -1}));
        assertArrayEquals(new int[]{2, 1, -1, -1}, Poker.computePositions("1/2/4", new int[]{1, 1, 0, 0}, new int[]{0, 2, -1, -1}));
        assertArrayEquals(new int[]{2, 1, -1, -1}, Poker.computePositions("1/2/4/8", new int[]{1, 1, 0, 0}, new int[]{0, 2, -1, -1}));
    }

    @Test
    public void playerJoinAndLeave() {
        final var random = new Random(1L);

        final var playerRegistry = new PlayerRepository();
        playerRegistry.register(new BotPlayer("Alice"));
        playerRegistry.register(new BotPlayer("Bob"));
        playerRegistry.register(new BotPlayer("Charlie"));
        playerRegistry.register(new BotPlayer("David"));

        var tableState = Poker.createTable(random, "100/200", 4);
        tableState = Poker.playerJoin(playerRegistry, tableState, 0, "Alice", 1000);
        tableState = Poker.playerJoin(playerRegistry, tableState, 1, "Bob", 2000);
        tableState = Poker.playerJoin(playerRegistry, tableState, 2, "Charlie", 3000);
        tableState = Poker.playerJoin(playerRegistry, tableState, 3, "David", 4000);

        assertEquals("Alice", tableState.getSeats()[0].getPlayerName());
        assertEquals(1000, tableState.getSeats()[0].getChips());
        assertEquals("Bob", tableState.getSeats()[1].getPlayerName());
        assertEquals(2000, tableState.getSeats()[1].getChips());
        assertEquals("Charlie", tableState.getSeats()[2].getPlayerName());
        assertEquals(3000, tableState.getSeats()[2].getChips());
        assertEquals("David", tableState.getSeats()[3].getPlayerName());
        assertEquals(4000, tableState.getSeats()[3].getChips());

        tableState = Poker.startHand(playerRegistry, tableState, random);

        assertEquals(2, tableState.getButtonAt());
        assertEquals(1, tableState.getBlinds()[3]);
        assertEquals(2, tableState.getBlinds()[0]);
        assertEquals(-1, tableState.getBlinds()[1]);
        assertEquals(0, tableState.getBlinds()[2]);

        tableState = Poker.playerLeave(tableState, 0);
        tableState = Poker.playerLeave(tableState, 1);
        tableState = Poker.playerLeave(tableState, 2);
        tableState = Poker.playerLeave(tableState, 3);

        assertNull(tableState.getSeats()[0].getPlayerName());
        assertEquals(0, tableState.getSeats()[0].getChips());
        assertNull(tableState.getSeats()[1].getPlayerName());
        assertEquals(0, tableState.getSeats()[1].getChips());
        assertNull(tableState.getSeats()[2].getPlayerName());
        assertEquals(0, tableState.getSeats()[2].getChips());
        assertNull(tableState.getSeats()[3].getPlayerName());
        assertEquals(0, tableState.getSeats()[3].getChips());
    }
}
