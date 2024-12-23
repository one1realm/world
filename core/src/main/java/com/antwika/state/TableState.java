package com.antwika.state;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class TableState {
    private String tableName;
    private String stakes;
    private long handId;
    private String communityCards;
    private int buttonAt;
    private int bigBlindAt;
    private int actionAt;
    private SeatState[] seats;
    private int[][] pot;
    private int[] blinds;
}
