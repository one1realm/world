package com.antwika.draw;

public class Card {
    public static void draw(Context ctx, int rank, int suit, int x, int y, int w, int h) {
        ctx.getSpriteBatch().draw(ctx.getDeck(),
            x - w / 2f,
            y - h / 2f,
            w,
            h,
            rank * (1f/14f),
            (suit + 1) * (1f/4f),
            (rank + 1) * (1f/14f),
            suit * (1f/4f));
    }

    public static void draw(Context ctx, String card, int x, int y, float scale) {
        final var rank = switch (card.charAt(0)) {
            case '2' -> 1;
            case '3' -> 2;
            case '4' -> 3;
            case '5' -> 4;
            case '6' -> 5;
            case '7' -> 6;
            case '8' -> 7;
            case '9' -> 8;
            case 'T' -> 9;
            case 'J' -> 10;
            case 'Q' -> 11;
            case 'K' -> 12;
            case 'A' -> 13;
            default -> 0;
        };

        final var suit = switch (card.charAt(1)) {
            case 'c' -> 0;
            case 'd' -> 1;
            case 'h' -> 2;
            case 's' -> 3;
            default -> 4;
        };

        draw(ctx, rank, suit, x, y, (int) (128 * scale), (int) (180 * scale));
    }
}
