package com.antwika.draw;

import com.badlogic.gdx.math.Vector2;

public class Logo {
    public static void draw(Context ctx, Vector2 position) {
        ctx.getSpriteBatch().begin();
        ctx.getSpriteBatch().draw(ctx.getOneRealmLogo(), position.x - (float) ctx.getOneRealmLogo().getWidth() / 2, position.y - (float) ctx.getOneRealmLogo().getHeight() / 2);
        ctx.getSpriteBatch().end();
    }
}
