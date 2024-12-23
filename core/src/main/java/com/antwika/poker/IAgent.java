package com.antwika.poker;

import java.util.UUID;

public interface IAgent {
    String getName();

    UUID getUuid();

    int promptPost(State state, int amount);

    int prompt(State state, int minCommit, int maxCommit);
}
