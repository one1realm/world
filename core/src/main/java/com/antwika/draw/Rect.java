package com.antwika.draw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Rect {
    public static void draw(Context ctx, Vector2 position, Vector2 size, Color color) {
        ctx.getShapeRenderer().setColor(color.r, color.g, color.b, color.a);
        ctx.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        ctx.getShapeRenderer().rect(position.x, position.y, size.x, size.y);
        ctx.getShapeRenderer().end();
    }
}
