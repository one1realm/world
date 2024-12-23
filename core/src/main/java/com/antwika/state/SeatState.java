package com.antwika.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class SeatState {
    private String playerName;
    private String cards;
    private int chips;
    private int committedChips;
    private Action action;
    private boolean mucked;
    private boolean button;
    private boolean missedSmallBlind;
    private boolean missedBigBlind;
    private boolean sitOut;
}
