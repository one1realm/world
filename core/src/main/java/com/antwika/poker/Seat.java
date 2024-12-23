package com.antwika.poker;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Builder(toBuilder = true)
@Getter
public class Seat {
    private final UUID agentId;
    private final String cards;
    private final int stack;
    private final boolean sitOut;
    private final boolean mucked;
    private final boolean acted;
    private final List<Integer> missedBlinds;

    public Seat(UUID agentId, String cards, int stack, boolean sitOut, boolean mucked, boolean acted, List<Integer> missedBlinds) {
        this.agentId = agentId;
        this.cards = cards;
        this.stack = stack;
        this.sitOut = sitOut;
        this.mucked = mucked;
        this.acted = acted;
        this.missedBlinds = missedBlinds;
    }
}
