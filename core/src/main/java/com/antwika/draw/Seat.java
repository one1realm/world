package com.antwika.draw;

import com.antwika.state.SeatState;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Seat {
    public static void draw(Context ctx, SeatState seatState, String cards, Vector2 position, float scale, Vector2 buttonOffset, Vector2 commitOffset, boolean isButton, Integer committed) {
        if (!seatState.isMucked()) {
            Cards.draw(ctx, seatState.getCards(), new Vector2(position.x, position.y + 24), scale * 0.4f, 0.5f, true);
        }


        Pill.draw(ctx, new Vector2(position.x, position.y), 50, 32, scale, 0.21f, 0.25f, 0.27f);
        Pill.draw(ctx, new Vector2(position.x, position.y), 50, 30, scale, 0.17f, 0.2f, 0.21f);
        Text.draw(ctx, new Vector2(position.x, position.y + 12), "Alice", Color.WHITE, false);
        Text.draw(ctx, new Vector2(position.x, position.y - 12), String.valueOf(seatState.getChips()), Color.WHITE, false);

        if (seatState.isButton()) {
            Button.draw(ctx, new Vector2(position).add(buttonOffset));
        }

        if (seatState.getCommittedChips() > 0) {
            Text.draw(ctx, new Vector2(position).add(commitOffset), String.valueOf(seatState.getCommittedChips()), Color.WHITE, false);
        }
    }
}
