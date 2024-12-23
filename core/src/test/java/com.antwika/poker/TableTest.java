package com.antwika.poker;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TableTest {
    @Test
    public void oneHand() {
        final var agentRepository = new AgentRepository();
        final var a0 = agentRepository.register(new Agent(UUID.randomUUID(), "Alice"));
        final var a1 = agentRepository.register(new Agent(UUID.randomUUID(), "Bob"));
        final var a2 = agentRepository.register(new Agent(UUID.randomUUID(), "Charlie"));
        final var a3 = agentRepository.register(new Agent(UUID.randomUUID(), "David"));

        final var table = TableFactory.createTexasHoldemTable(agentRepository);

        Table.join(agentRepository, table, 0, a0, 1000);
        Table.join(agentRepository, table, 1, a1, 1000);
        Table.join(agentRepository, table, 2, a2, 1000);
        Table.join(agentRepository, table, 3, a3, 1000);

        table.progress(1);

        assertEquals(33, table.getStates().size());

        assertFalse(table.getStates().get(table.getStates().size() - 1).isOngoing());

        { // Initial state
            final var state = table.getStates().get(16);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(0, state.getRoundIndex());
            assertEquals(3, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(1000, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(990, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(1000, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(1, state.getPots().size());

            assertEquals(List.of(0, 10, 20, 0), state.getPots().get(0));

            assertTrue(state.isOngoing());
        }

        { // David calls 20
            final var state = table.getStates().get(17);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(0, state.getRoundIndex());
            assertEquals(0, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(1000, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(990, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertTrue(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(1, state.getPots().size());

            assertEquals(List.of(0, 10, 20, 20), state.getPots().get(0));

            assertTrue(state.isOngoing());
        }

        { // Alice calls 20
            final var state = table.getStates().get(18);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(0, state.getRoundIndex());
            assertEquals(1, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertTrue(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(990, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertTrue(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(1, state.getPots().size());

            assertEquals(List.of(20, 10, 20, 20), state.getPots().get(0));

            assertTrue(state.isOngoing());
        }

        { // Bob calls 10
            final var state = table.getStates().get(19);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(0, state.getRoundIndex());
            assertEquals(2, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertTrue(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertTrue(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(1, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));

            assertTrue(state.isOngoing());
        }

        { // Charlie checks, dealt flop
            final var state = table.getStates().get(20);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9s", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(1, state.getRoundIndex());
            assertEquals(1, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(2, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));

            assertTrue(state.isOngoing());
        }

        { // Bob checks
            final var state = table.getStates().get(21);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9s", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(1, state.getRoundIndex());
            assertEquals(2, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(2, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));

            assertTrue(state.isOngoing());
        }

        { // Charlie checks
            final var state = table.getStates().get(22);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9s", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(1, state.getRoundIndex());
            assertEquals(3, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertTrue(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(2, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));

            assertTrue(state.isOngoing());
        }

        { // David checks
            final var state = table.getStates().get(23);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9s", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(1, state.getRoundIndex());
            assertEquals(0, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertTrue(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertTrue(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(2, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));

            assertTrue(state.isOngoing());
        }

        { // Alice checks, and turn is dealt
            final var state = table.getStates().get(24);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(2, state.getRoundIndex());
            assertEquals(1, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(3, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));

            assertTrue(state.isOngoing());
        }

        { // Bob checks
            final var state = table.getStates().get(25);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(2, state.getRoundIndex());
            assertEquals(2, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(3, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));

            assertTrue(state.isOngoing());
        }

        { // Charlie checks
            final var state = table.getStates().get(26);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(2, state.getRoundIndex());
            assertEquals(3, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertTrue(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(3, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));

            assertTrue(state.isOngoing());
        }

        { // David checks
            final var state = table.getStates().get(27);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(2, state.getRoundIndex());
            assertEquals(0, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertTrue(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertTrue(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(3, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));

            assertTrue(state.isOngoing());
        }

        { // Alice checks, and river is dealt
            final var state = table.getStates().get(28);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTsJs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(3, state.getRoundIndex());
            assertEquals(1, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(4, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(3));

            assertTrue(state.isOngoing());
        }

        { // Bob checks
            final var state = table.getStates().get(29);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTsJs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(3, state.getRoundIndex());
            assertEquals(2, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(4, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(3));

            assertTrue(state.isOngoing());
        }

        { // Charlie checks
            final var state = table.getStates().get(30);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTsJs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(3, state.getRoundIndex());
            assertEquals(3, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertTrue(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(4, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(3));

            assertTrue(state.isOngoing());
        }

        { // David checks
            final var state = table.getStates().get(31);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTsJs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(3, state.getRoundIndex());
            assertEquals(0, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(980, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(980, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertTrue(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(980, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertTrue(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(980, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertTrue(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(4, state.getPots().size());

            assertEquals(List.of(20, 20, 20, 20), state.getPots().get(0));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(1));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(2));
            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(3));

            assertTrue(state.isOngoing());
        }

        { // Alice checks, and pots are distributed
            final var state = table.getStates().get(32);

            assertEquals("10/20", state.getStakes());
            assertEquals(1L, state.getHandId());
            assertEquals("7s8s9sTsJs", state.getCommunityCards());
            assertEquals(List.of(0, 1, 2, -1), state.getBlinds());
            assertEquals(4, state.getRoundIndex());
            assertEquals(1, state.getActionAt());

            assertEquals(4, state.getSeats().size());

            final var seat0 = state.getSeats().get(0);
            assertEquals(a0, seat0.getAgentId());
            assertEquals("2c2d", seat0.getCards());
            assertEquals(1000, seat0.getStack());
            assertFalse(seat0.isSitOut());
            assertFalse(seat0.isMucked());
            assertFalse(seat0.isActed());
            assertEquals(List.of(), seat0.getMissedBlinds());

            final var seat1 = state.getSeats().get(1);
            assertEquals(a1, seat1.getAgentId());
            assertEquals("3c3d", seat1.getCards());
            assertEquals(1000, seat1.getStack());
            assertFalse(seat1.isSitOut());
            assertFalse(seat1.isMucked());
            assertFalse(seat1.isActed());
            assertEquals(List.of(), seat1.getMissedBlinds());

            final var seat2 = state.getSeats().get(2);
            assertEquals(a2, seat2.getAgentId());
            assertEquals("4c4d", seat2.getCards());
            assertEquals(1000, seat2.getStack());
            assertFalse(seat2.isSitOut());
            assertFalse(seat2.isMucked());
            assertFalse(seat2.isActed());
            assertEquals(List.of(), seat2.getMissedBlinds());

            final var seat3 = state.getSeats().get(3);
            assertEquals(a3, seat3.getAgentId());
            assertEquals("5c5d", seat3.getCards());
            assertEquals(1000, seat3.getStack());
            assertFalse(seat3.isSitOut());
            assertFalse(seat3.isMucked());
            assertFalse(seat3.isActed());
            assertEquals(List.of(), seat3.getMissedBlinds());

            assertEquals(1, state.getPots().size());

            assertEquals(List.of(0, 0, 0, 0), state.getPots().get(0));

            assertFalse(state.isOngoing());
        }
    }

    @Test
    public void multipleHands() {
        final var agentRepository = new AgentRepository();
        final var a0 = agentRepository.register(new Agent(UUID.randomUUID(), "Alice"));
        final var a1 = agentRepository.register(new Agent(UUID.randomUUID(), "Bob"));
        final var a2 = agentRepository.register(new Agent(UUID.randomUUID(), "Charlie"));
        final var a3 = agentRepository.register(new Agent(UUID.randomUUID(), "David"));

        final var table = TableFactory.createTexasHoldemTable(agentRepository);

        Table.join(agentRepository, table, 0, a0, 1000);
        Table.join(agentRepository, table, 1, a1, 1000);
        Table.join(agentRepository, table, 2, a2, 1000);
        Table.join(agentRepository, table, 3, a3, 1000);

        table.progress(5);
    }
}
