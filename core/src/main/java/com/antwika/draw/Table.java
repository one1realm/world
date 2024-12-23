package com.antwika.draw;

import com.antwika.state.TableState;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import java.util.Arrays;

public class Table {
    private static SeatLayout[] seatLayouts = new SeatLayout[]{
        new SeatLayout(new Vector2(0, -140), new Vector2(-55, 45), new Vector2(0, 75)),
        new SeatLayout(new Vector2(-220, -90), new Vector2(65, 20), new Vector2(70, 45)),
        new SeatLayout(new Vector2(-250, 60), new Vector2(65, 20), new Vector2(80, -5)),
        new SeatLayout(new Vector2(0, 130), new Vector2(-60, -35), new Vector2(0, -45)),
        new SeatLayout(new Vector2(250, 60), new Vector2(-65, 20), new Vector2(-80, -5)),
        new SeatLayout(new Vector2(220, -90), new Vector2(-65, 20), new Vector2(-70, 45))
    };

    public static void draw(Context ctx, TableState tableState, Vector2 position) {
        Pill.draw(ctx, position, 300, 120, 1f, 0.21f, 0.25f, 0.27f);
        Pill.draw(ctx, position, 300, 110, 1f, 0.17f, 0.2f, 0.21f);
        Text.draw(ctx, new Vector2(position.x, position.y + 56), tableState.getTableName() + " " + tableState.getStakes(), new Color(0.40f, 0.48f, 0.48f, 1f), true);

        // Logo.draw(ctx, position);
        Rect.draw(ctx, new Vector2(position.x - 218f / 2, position.y - 18), new Vector2(218f, 64), new Color(0.21f, 0.25f, 0.27f, 1f));
        Rect.draw(ctx, new Vector2(position.x - 214f / 2, position.y - 16), new Vector2(214f, 60), new Color(0.17f, 0.2f, 0.21f, 1f));
        Cards.draw(ctx, tableState.getCommunityCards(), new Vector2(position.x - 106, position.y + 34 - 20), 0.3f, 1.1f, false);

        final var pots = tableState.getPot();
        var pot = Arrays.stream(pots).mapToInt(ints -> Arrays.stream(ints).sum()).sum();
        Text.draw(ctx, new Vector2(position.x, position.y - 30), "Pot " + pot, Color.WHITE, false);

        // Seats
        final var seats = tableState.getSeats();
        for (int i = 0; i < seats.length; i++) {
            final var seat = seats[i];
            final var seatLayout = seatLayouts[i];
            Seat.draw(ctx, seat, "AdKh", new Vector2(position).add(seatLayout.positionOffset()), 1f, seatLayout.commitOffset(), seatLayout.buttonOffset(), true, 1000);
        }
    }

    private record SeatLayout(Vector2 positionOffset, Vector2 commitOffset, Vector2 buttonOffset) {
    }
}
