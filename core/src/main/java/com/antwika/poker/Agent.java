package com.antwika.poker;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Agent implements IAgent {
    private final UUID uuid;
    private final String name;

    public Agent(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int promptPost(State state, int amount) {
        return 1;
    }

    @Override
    public int prompt(State state, int minCommit, int maxCommit) {
        final var seat = state.getSeats().stream()
            .filter(s -> s.getAgentId().equals(getUuid()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Could not find my own seat"));

        return minCommit;
    }
}
