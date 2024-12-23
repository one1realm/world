package com.antwika.poker;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static String shuffle(Random random, String cards) {
        if (cards.isEmpty()) throw new RuntimeException("Cards string length must not be empty");
        if (cards.length() % 2 != 0) throw new RuntimeException("Cards string length must be even");

        final var unshuffled = new ArrayList<String>();
        for (int i = 0; i < cards.length(); i += 2) {
            unshuffled.add("" + cards.charAt(i) + cards.charAt(i + 1));
        }

        final var shuffled = new ArrayList<String>();
        while (!unshuffled.isEmpty()) {
            final var cardIndex = unshuffled.size();
            final var randomIndex = random.nextInt(cardIndex);
            shuffled.add(unshuffled.remove(randomIndex));
        }

        return String.join("", shuffled);
    }
}
