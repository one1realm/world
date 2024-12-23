package com.antwika;

import com.antwika.state.TableState;

public class BotPlayer implements IPlayer {
    private final String playerName;

    public BotPlayer(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public int promptPost(TableState tableState, int amount) {
        return amount;
    }

    @Override
    public int prompt(TableState tableState, int min, int max) {
        return 0;
    }
}
