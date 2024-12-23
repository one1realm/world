package com.antwika.draw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Button {
    public static void draw(Context ctx, Vector2 position) {
        Circle.draw(ctx, position, 10, 1f, new Color(0.5f, 0.5f, 0.5f, 1f));
        Circle.draw(ctx, position, 8, 1f, new Color(0.85f, 0.85f, 0.85f, 1f));
        Text.draw(ctx, position, "D", Color.BLACK, true);
    }
}
