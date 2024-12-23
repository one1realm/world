package com.antwika.draw;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Pill {
    public static void draw(Context ctx, Vector2 position, float width, float radius, float scale, float red, float green, float blue) {
        ctx.getShapeRenderer().begin(ShapeRenderer.ShapeType.Filled);
        ctx.getShapeRenderer().setColor(red, green, blue, 1);
        ctx.getShapeRenderer().circle(position.x - width / 2, position.y, radius * scale);
        ctx.getShapeRenderer().circle(position.x + width / 2, position.y, radius * scale);
        float height = radius * 2;
        ctx.getShapeRenderer().rect(position.x - width / 2, position.y + radius - height, width, height);
        ctx.getShapeRenderer().end();
    }
}
