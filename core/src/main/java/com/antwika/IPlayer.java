package com.antwika;

import com.antwika.state.TableState;

public interface IPlayer {
    String getPlayerName();

    int promptPost(TableState tableState, int amount);

    int prompt(TableState tableState, int min, int max);
}
