package com.antwika.draw;

import com.badlogic.gdx.math.Vector2;

public class Cards {
    public static void draw(Context ctx, String cards, Vector2 position, float scale, float spacing, boolean center) {
        ctx.getSpriteBatch().begin();
        final var numberOfCards = cards.length() / 2;

        var cardW = 128;

        for (int i = 0; i < cards.length(); i += 2) {
            final var cardIndex = i / 2;
            final var card = cards.substring(i, i + 2);

            var cardX = 0f;
            cardX += cardIndex * cardW;
            if (center) {
                cardX -= (float) (numberOfCards * cardW) / 2;
            }
            cardX += (float) (cardW / 2);
            cardX *= spacing;
            cardX *= scale;
            cardX += position.x;
            Card.draw(ctx, card, (int) cardX, (int) position.y, scale);
        }
        ctx.getSpriteBatch().end();
    }
}
