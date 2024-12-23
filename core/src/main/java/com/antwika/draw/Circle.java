package com.antwika.draw;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Circle {
    public static void draw(Context ctx, Vector2 position, float radius, float scale, Color color) {
        ctx.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        ctx.getShapeRenderer().setColor(color.r, color.g, color.b, color.a);
        ctx.getShapeRenderer().circle(position.x, position.y, radius * scale);
        ctx.getShapeRenderer().end();
    }
}
