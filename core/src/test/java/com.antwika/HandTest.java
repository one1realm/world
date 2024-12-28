package com.antwika;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    public void toHand() {
        assertEquals(0b0L, Hand.toHand(""));
        assertEquals(0b1L, Hand.toHand("2c"));
        assertEquals(0b1L, Hand.toHand("2c"));
        assertEquals(0b10L, Hand.toHand("3c"));
        assertEquals(0b1000000000000L, Hand.toHand("Ac"));
        assertEquals(0b10000000000000L, Hand.toHand("2d"));
        assertEquals(0b100000000000000L, Hand.toHand("3d"));
        assertEquals(0b1000000000000000000000000000000000000000000000000000L, Hand.toHand("As"));
        assertEquals(0b11L, Hand.toHand("2c3c"));
        assertEquals(0b1111111111111111111111111111111111111111111111111111L, Hand.toHand("2c3c4c5c6c7c8c9cTcJcQcKcAc2d3d4d5d6d7d8d9dTdJdQdKdAd2h3h4h5h6h7h8h9hThJhQhKhAh2s3s4s5s6s7s8s9sTsJsQsKsAs"));
    }

    @Test
    public void toSpacedNotation() {
        assertEquals("", Hand.toSpacedNotation(""));
        assertEquals("2c", Hand.toSpacedNotation("2c"));
        assertEquals("2c 3c", Hand.toSpacedNotation("2c3c"));
        assertEquals("2c 3c 4c", Hand.toSpacedNotation("2c3c4c"));
    }

    @Test
    public void toNotation() {
        assertEquals("", Hand.toNotation(0b0L));
        assertEquals("2c", Hand.toNotation(0b1L));
        assertEquals("3c", Hand.toNotation(0b10L));
        assertEquals("Ac", Hand.toNotation(0b1000000000000L));
        assertEquals("2d", Hand.toNotation(0b10000000000000L));
        assertEquals("3d", Hand.toNotation(0b100000000000000L));
        assertEquals("As", Hand.toNotation(0b1000000000000000000000000000000000000000000000000000L));
        assertEquals("2c3c", Hand.toNotation(0b11L));
        assertEquals("2c3c4c5c6c7c8c9cTcJcQcKcAc2d3d4d5d6d7d8d9dTdJdQdKdAd2h3h4h5h6h7h8h9hThJhQhKhAh2s3s4s5s6s7s8s9sTsJsQsKsAs", Hand.toNotation(0b1111111111111111111111111111111111111111111111111111L));
    }

    @Test
    public void highestBits() {
        assertEquals(0b0L, Hand.highestBits(0b0L, 5));
        assertEquals(0b1L, Hand.highestBits(0b1L, 5));
        assertEquals(0b01L, Hand.highestBits(0b01L, 5));
        assertEquals(0b10L, Hand.highestBits(0b10L, 5));
        assertEquals(0b11L, Hand.highestBits(0b11L, 5));
        assertEquals(0b11111L, Hand.highestBits(0b11111L, 5));
        assertEquals(0b111110L, Hand.highestBits(0b111111L, 5));
        assertEquals(0b1111100L, Hand.highestBits(0b1111111L, 5));
        assertEquals(0b1011110L, Hand.highestBits(0b1011111L, 5));
        assertEquals(0b10101010L, Hand.highestBits(0b10101010L, 5));
        assertEquals(0b1010101010L, Hand.highestBits(0b1010101010L, 5));
        assertEquals(0b101010101000L, Hand.highestBits(0b101010101010L, 5));
    }

    @Test
    public void value() {
        assertEquals(0b111111111000000000000000000000000000000000000000L, 0b111111111111111111111111111111111111111111111111L & Hand.TYPE);
        assertEquals(0b000000000111111111111100000000000000000000000000L, 0b111111111111111111111111111111111111111111111111L & Hand.MAJOR);
        assertEquals(0b000000000000000000000011111111111110000000000000L, 0b111111111111111111111111111111111111111111111111L & Hand.MINOR);
        assertEquals(0b000000000000000000000000000000000001111111111111L, 0b111111111111111111111111111111111111111111111111L & Hand.KICKERS);

        assertEquals(Hand.STRAIGHT_FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.SPADES_QUEEN | Hand.SPADES_JACK | Hand.SPADES_TEN)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.SPADES_QUEEN | Hand.SPADES_JACK | Hand.SPADES_TEN)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.SPADES_QUEEN | Hand.SPADES_JACK | Hand.SPADES_TEN)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.SPADES_QUEEN | Hand.SPADES_JACK | Hand.SPADES_TEN)));

        assertEquals(Hand.QUADS, Hand.typeFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_ACE | Hand.CLUBS_ACE | Hand.SPADES_KING)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_ACE | Hand.CLUBS_ACE | Hand.SPADES_KING)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_ACE | Hand.CLUBS_ACE | Hand.SPADES_KING)));
        assertEquals(Hand.KING, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_ACE | Hand.CLUBS_ACE | Hand.SPADES_KING)));

        assertEquals(Hand.QUADS, Hand.typeFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));
        assertEquals(Hand.KING, Hand.majorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));
        assertEquals(Hand.ACE, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_KING | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));

        assertEquals(Hand.FULL_HOUSE, Hand.typeFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));
        assertEquals(Hand.KING, Hand.majorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));
        assertEquals(Hand.ACE, Hand.minorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.HEARTS_KING | Hand.DIAMONDS_KING | Hand.CLUBS_KING)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX | Hand.SPADES_FOUR)));
        assertEquals(Hand.QUEEN, Hand.majorFromValue(Hand.valueFromHand(Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX | Hand.SPADES_FOUR)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX | Hand.SPADES_FOUR)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_QUEEN | Hand.SPADES_TEN | Hand.SPADES_EIGHT | Hand.SPADES_SIX | Hand.SPADES_FOUR)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.HEARTS_ACE | Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.HEARTS_ACE | Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.HEARTS_ACE | Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.HEARTS_ACE | Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX | Hand.HEARTS_FOUR)));
        assertEquals(Hand.QUEEN, Hand.majorFromValue(Hand.valueFromHand(Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX | Hand.HEARTS_FOUR)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX | Hand.HEARTS_FOUR)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.HEARTS_QUEEN | Hand.HEARTS_TEN | Hand.HEARTS_EIGHT | Hand.HEARTS_SIX | Hand.HEARTS_FOUR)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.DIAMONDS_ACE | Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.DIAMONDS_ACE | Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.DIAMONDS_ACE | Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.DIAMONDS_ACE | Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX | Hand.DIAMONDS_FOUR)));
        assertEquals(Hand.QUEEN, Hand.majorFromValue(Hand.valueFromHand(Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX | Hand.DIAMONDS_FOUR)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX | Hand.DIAMONDS_FOUR)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.DIAMONDS_QUEEN | Hand.DIAMONDS_TEN | Hand.DIAMONDS_EIGHT | Hand.DIAMONDS_SIX | Hand.DIAMONDS_FOUR)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX)));

        assertEquals(Hand.FLUSH, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX | Hand.CLUBS_FOUR)));
        assertEquals(Hand.QUEEN, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX | Hand.CLUBS_FOUR)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX | Hand.CLUBS_FOUR)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_QUEEN | Hand.CLUBS_TEN | Hand.CLUBS_EIGHT | Hand.CLUBS_SIX | Hand.CLUBS_FOUR)));

        assertEquals(Hand.STRAIGHT, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.HEARTS_KING | Hand.CLUBS_QUEEN | Hand.HEARTS_JACK | Hand.CLUBS_TEN)));
        assertEquals(Hand.ACE, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.HEARTS_KING | Hand.CLUBS_QUEEN | Hand.HEARTS_JACK | Hand.CLUBS_TEN)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.HEARTS_KING | Hand.CLUBS_QUEEN | Hand.HEARTS_JACK | Hand.CLUBS_TEN)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_ACE | Hand.HEARTS_KING | Hand.CLUBS_QUEEN | Hand.HEARTS_JACK | Hand.CLUBS_TEN)));

        assertEquals(Hand.STRAIGHT, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_TEN | Hand.HEARTS_NINE | Hand.CLUBS_EIGHT | Hand.HEARTS_SEVEN | Hand.CLUBS_SIX)));
        assertEquals(Hand.TEN, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_TEN | Hand.HEARTS_NINE | Hand.CLUBS_EIGHT | Hand.HEARTS_SEVEN | Hand.CLUBS_SIX)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_TEN | Hand.HEARTS_NINE | Hand.CLUBS_EIGHT | Hand.HEARTS_SEVEN | Hand.CLUBS_SIX)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_TEN | Hand.HEARTS_NINE | Hand.CLUBS_EIGHT | Hand.HEARTS_SEVEN | Hand.CLUBS_SIX)));

        assertEquals(Hand.STRAIGHT, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.HEARTS_FOUR | Hand.CLUBS_THREE | Hand.HEARTS_TWO | Hand.CLUBS_ACE)));
        assertEquals(Hand.FIVE, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.HEARTS_FOUR | Hand.CLUBS_THREE | Hand.HEARTS_TWO | Hand.CLUBS_ACE)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.HEARTS_FOUR | Hand.CLUBS_THREE | Hand.HEARTS_TWO | Hand.CLUBS_ACE)));
        assertEquals(Hand.NONE, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.HEARTS_FOUR | Hand.CLUBS_THREE | Hand.HEARTS_TWO | Hand.CLUBS_ACE)));

        assertEquals(Hand.TRIPS, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.DIAMONDS_FIVE | Hand.HEARTS_FIVE | Hand.HEARTS_TWO | Hand.CLUBS_THREE)));
        assertEquals(Hand.FIVE, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.DIAMONDS_FIVE | Hand.HEARTS_FIVE | Hand.HEARTS_TWO | Hand.CLUBS_THREE)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.DIAMONDS_FIVE | Hand.HEARTS_FIVE | Hand.HEARTS_TWO | Hand.CLUBS_THREE)));
        assertEquals(Hand.THREE | Hand.TWO, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_FIVE | Hand.DIAMONDS_FIVE | Hand.HEARTS_FIVE | Hand.HEARTS_TWO | Hand.CLUBS_THREE)));

        assertEquals(Hand.TRIPS, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_SEVEN | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));
        assertEquals(Hand.SEVEN, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_SEVEN | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_SEVEN | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));
        assertEquals(Hand.ACE | Hand.JACK, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_SEVEN | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));

        assertEquals(Hand.TWO_PAIR, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));
        assertEquals(Hand.JACK, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));
        assertEquals(Hand.SEVEN, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));
        assertEquals(Hand.ACE, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_JACK)));

        assertEquals(Hand.ONE_PAIR, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));
        assertEquals(Hand.SEVEN, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));
        assertEquals(Hand.ACE | Hand.KING | Hand.JACK, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_SEVEN | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));

        assertEquals(Hand.HIGH_CARD, Hand.typeFromValue(Hand.valueFromHand(Hand.CLUBS_TWO | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));
        assertEquals(Hand.NONE, Hand.majorFromValue(Hand.valueFromHand(Hand.CLUBS_TWO | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));
        assertEquals(Hand.NONE, Hand.minorFromValue(Hand.valueFromHand(Hand.CLUBS_TWO | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));
        assertEquals(Hand.ACE | Hand.KING | Hand.JACK | Hand.SEVEN | Hand.TWO, Hand.kickersFromValue(Hand.valueFromHand(Hand.CLUBS_TWO | Hand.DIAMONDS_SEVEN | Hand.HEARTS_JACK | Hand.HEARTS_ACE | Hand.CLUBS_KING)));

        assertEquals(Hand.KING, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_ACE | Hand.CLUBS_ACE | Hand.SPADES_KING | Hand.SPADES_QUEEN)));
        assertEquals(Hand.KING | Hand.QUEEN, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_ACE | Hand.CLUBS_JACK | Hand.SPADES_KING | Hand.SPADES_QUEEN)));
        assertEquals(Hand.KING, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_JACK | Hand.CLUBS_JACK | Hand.SPADES_KING | Hand.SPADES_QUEEN)));
        assertEquals(Hand.KING | Hand.QUEEN | Hand.JACK, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_ACE | Hand.DIAMONDS_JACK | Hand.CLUBS_TWO | Hand.SPADES_KING | Hand.SPADES_QUEEN)));
        assertEquals(Hand.ACE | Hand.KING | Hand.QUEEN | Hand.JACK | Hand.SEVEN, Hand.kickersFromValue(Hand.valueFromHand(Hand.SPADES_ACE | Hand.HEARTS_SEVEN | Hand.DIAMONDS_JACK | Hand.CLUBS_TWO | Hand.SPADES_KING | Hand.SPADES_QUEEN)));
    }

    @Test
    public void majorMinorKickers() {
        long type = Hand.STRAIGHT_FLUSH;
        long major = Hand.RANK & Hand.ACE;
        long minor = Hand.RANK & Hand.KING;
        long kickers = Hand.RANK & Hand.QUEEN;
        long value = (type << 39) | (major << 26) | (minor << 13) | kickers;
        assertEquals(0b100000000100000000000001000000000000010000000000L, value);
    }

    @Test
    public void highestOneBit() {
        assertEquals(0b0000L, Long.highestOneBit(0b0000L));
        assertEquals(0b0001L, Long.highestOneBit(0b0001L));
        assertEquals(0b0010L, Long.highestOneBit(0b0010L));
        assertEquals(0b0010L, Long.highestOneBit(0b0011L));
        assertEquals(0b0100L, Long.highestOneBit(0b0100L));
        assertEquals(0b0100L, Long.highestOneBit(0b0101L));
        assertEquals(0b0100L, Long.highestOneBit(0b0110L));
        assertEquals(0b0100L, Long.highestOneBit(0b0111L));
        assertEquals(0b1000L, Long.highestOneBit(0b1000L));
        assertEquals(0b1000L, Long.highestOneBit(0b1001L));
        assertEquals(0b1000L, Long.highestOneBit(0b1010L));
        assertEquals(0b1000L, Long.highestOneBit(0b1011L));
        assertEquals(0b1000L, Long.highestOneBit(0b1100L));
        assertEquals(0b1000L, Long.highestOneBit(0b1101L));
        assertEquals(0b1000L, Long.highestOneBit(0b1110L));
        assertEquals(0b1000L, Long.highestOneBit(0b1111L));
    }

    @Test
    public void bitmasks() {
        assertEquals(0b0L, Hand.NONE);
        assertEquals(0b000000001L, Hand.HIGH_CARD);
        assertEquals(0b000000010L, Hand.ONE_PAIR);
        assertEquals(0b000000100L, Hand.TWO_PAIR);
        assertEquals(0b000001000L, Hand.TRIPS);
        assertEquals(0b000010000L, Hand.STRAIGHT);
        assertEquals(0b000100000L, Hand.FLUSH);
        assertEquals(0b001000000L, Hand.FULL_HOUSE);
        assertEquals(0b010000000L, Hand.QUADS);
        assertEquals(0b100000000L, Hand.STRAIGHT_FLUSH);
        assertEquals(0b1111111111111L, Hand.SUIT);
        assertEquals(0b1111111111111L, Hand.RANK);
        assertEquals(0b0000000000001L, Hand.TWO);
        assertEquals(0b0000000000010L, Hand.THREE);
        assertEquals(0b0000000000100L, Hand.FOUR);
        assertEquals(0b0000000001000L, Hand.FIVE);
        assertEquals(0b0000000010000L, Hand.SIX);
        assertEquals(0b0000000100000L, Hand.SEVEN);
        assertEquals(0b0000001000000L, Hand.EIGHT);
        assertEquals(0b0000010000000L, Hand.NINE);
        assertEquals(0b0000100000000L, Hand.TEN);
        assertEquals(0b0001000000000L, Hand.JACK);
        assertEquals(0b0010000000000L, Hand.QUEEN);
        assertEquals(0b0100000000000L, Hand.KING);
        assertEquals(0b1000000000000L, Hand.ACE);
        assertEquals(0b0000000000000000000000000000000000000000000000000001L, Hand.CLUBS_TWO);
        assertEquals(0b0000000000000000000000000000000000000000000000000010L, Hand.CLUBS_THREE);
        assertEquals(0b0000000000000000000000000000000000000000000000000100L, Hand.CLUBS_FOUR);
        assertEquals(0b0000000000000000000000000000000000000000000000001000L, Hand.CLUBS_FIVE);
        assertEquals(0b0000000000000000000000000000000000000000000000010000L, Hand.CLUBS_SIX);
        assertEquals(0b0000000000000000000000000000000000000000000000100000L, Hand.CLUBS_SEVEN);
        assertEquals(0b0000000000000000000000000000000000000000000001000000L, Hand.CLUBS_EIGHT);
        assertEquals(0b0000000000000000000000000000000000000000000010000000L, Hand.CLUBS_NINE);
        assertEquals(0b0000000000000000000000000000000000000000000100000000L, Hand.CLUBS_TEN);
        assertEquals(0b0000000000000000000000000000000000000000001000000000L, Hand.CLUBS_JACK);
        assertEquals(0b0000000000000000000000000000000000000000010000000000L, Hand.CLUBS_QUEEN);
        assertEquals(0b0000000000000000000000000000000000000000100000000000L, Hand.CLUBS_KING);
        assertEquals(0b0000000000000000000000000000000000000001000000000000L, Hand.CLUBS_ACE);
        assertEquals(0b0000000000000000000000000000000000000010000000000000L, Hand.DIAMONDS_TWO);
        assertEquals(0b0000000000000000000000000000000000000100000000000000L, Hand.DIAMONDS_THREE);
        assertEquals(0b0000000000000000000000000000000000001000000000000000L, Hand.DIAMONDS_FOUR);
        assertEquals(0b0000000000000000000000000000000000010000000000000000L, Hand.DIAMONDS_FIVE);
        assertEquals(0b0000000000000000000000000000000000100000000000000000L, Hand.DIAMONDS_SIX);
        assertEquals(0b0000000000000000000000000000000001000000000000000000L, Hand.DIAMONDS_SEVEN);
        assertEquals(0b0000000000000000000000000000000010000000000000000000L, Hand.DIAMONDS_EIGHT);
        assertEquals(0b0000000000000000000000000000000100000000000000000000L, Hand.DIAMONDS_NINE);
        assertEquals(0b0000000000000000000000000000001000000000000000000000L, Hand.DIAMONDS_TEN);
        assertEquals(0b0000000000000000000000000000010000000000000000000000L, Hand.DIAMONDS_JACK);
        assertEquals(0b0000000000000000000000000000100000000000000000000000L, Hand.DIAMONDS_QUEEN);
        assertEquals(0b0000000000000000000000000001000000000000000000000000L, Hand.DIAMONDS_KING);
        assertEquals(0b0000000000000000000000000010000000000000000000000000L, Hand.DIAMONDS_ACE);
        assertEquals(0b0000000000000000000000000100000000000000000000000000L, Hand.HEARTS_TWO);
        assertEquals(0b0000000000000000000000001000000000000000000000000000L, Hand.HEARTS_THREE);
        assertEquals(0b0000000000000000000000010000000000000000000000000000L, Hand.HEARTS_FOUR);
        assertEquals(0b0000000000000000000000100000000000000000000000000000L, Hand.HEARTS_FIVE);
        assertEquals(0b0000000000000000000001000000000000000000000000000000L, Hand.HEARTS_SIX);
        assertEquals(0b0000000000000000000010000000000000000000000000000000L, Hand.HEARTS_SEVEN);
        assertEquals(0b0000000000000000000100000000000000000000000000000000L, Hand.HEARTS_EIGHT);
        assertEquals(0b0000000000000000001000000000000000000000000000000000L, Hand.HEARTS_NINE);
        assertEquals(0b0000000000000000010000000000000000000000000000000000L, Hand.HEARTS_TEN);
        assertEquals(0b0000000000000000100000000000000000000000000000000000L, Hand.HEARTS_JACK);
        assertEquals(0b0000000000000001000000000000000000000000000000000000L, Hand.HEARTS_QUEEN);
        assertEquals(0b0000000000000010000000000000000000000000000000000000L, Hand.HEARTS_KING);
        assertEquals(0b0000000000000100000000000000000000000000000000000000L, Hand.HEARTS_ACE);
        assertEquals(0b0000000000001000000000000000000000000000000000000000L, Hand.SPADES_TWO);
        assertEquals(0b0000000000010000000000000000000000000000000000000000L, Hand.SPADES_THREE);
        assertEquals(0b0000000000100000000000000000000000000000000000000000L, Hand.SPADES_FOUR);
        assertEquals(0b0000000001000000000000000000000000000000000000000000L, Hand.SPADES_FIVE);
        assertEquals(0b0000000010000000000000000000000000000000000000000000L, Hand.SPADES_SIX);
        assertEquals(0b0000000100000000000000000000000000000000000000000000L, Hand.SPADES_SEVEN);
        assertEquals(0b0000001000000000000000000000000000000000000000000000L, Hand.SPADES_EIGHT);
        assertEquals(0b0000010000000000000000000000000000000000000000000000L, Hand.SPADES_NINE);
        assertEquals(0b0000100000000000000000000000000000000000000000000000L, Hand.SPADES_TEN);
        assertEquals(0b0001000000000000000000000000000000000000000000000000L, Hand.SPADES_JACK);
        assertEquals(0b0010000000000000000000000000000000000000000000000000L, Hand.SPADES_QUEEN);
        assertEquals(0b0100000000000000000000000000000000000000000000000000L, Hand.SPADES_KING);
        assertEquals(0b1000000000000000000000000000000000000000000000000000L, Hand.SPADES_ACE);
        assertEquals(0b0000000000000000000000000000000000000001111111111111L, Hand.CLUBS);
        assertEquals(0b0000000000000000000000000011111111111110000000000000L, Hand.DIAMONDS);
        assertEquals(0b0000000000000111111111111100000000000000000000000000L, Hand.HEARTS);
        assertEquals(0b1111111111111000000000000000000000000000000000000000L, Hand.SPADES);
        assertEquals(0b0000000000001000000000000100000000000010000000000001L, Hand.TWOS);
        assertEquals(0b0000000000010000000000001000000000000100000000000010L, Hand.THREES);
        assertEquals(0b0000000000100000000000010000000000001000000000000100L, Hand.FOURS);
        assertEquals(0b0000000001000000000000100000000000010000000000001000L, Hand.FIVES);
        assertEquals(0b0000000010000000000001000000000000100000000000010000L, Hand.SIXES);
        assertEquals(0b0000000100000000000010000000000001000000000000100000L, Hand.SEVENS);
        assertEquals(0b0000001000000000000100000000000010000000000001000000L, Hand.EIGHTS);
        assertEquals(0b0000010000000000001000000000000100000000000010000000L, Hand.NINES);
        assertEquals(0b0000100000000000010000000000001000000000000100000000L, Hand.TENS);
        assertEquals(0b0001000000000000100000000000010000000000001000000000L, Hand.JACKS);
        assertEquals(0b0010000000000001000000000000100000000000010000000000L, Hand.QUEENS);
        assertEquals(0b0100000000000010000000000001000000000000100000000000L, Hand.KINGS);
        assertEquals(0b1000000000000100000000000010000000000001000000000000L, Hand.ACES);
        assertEquals(0b0000000000000000000000000000000000000001000000001111L, Hand.FIVE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000000011111L, Hand.SIX_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000000111110L, Hand.SEVEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000001111100L, Hand.EIGHT_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000011111000L, Hand.NINE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000111110000L, Hand.TEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000001111100000L, Hand.JACK_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000011111000000L, Hand.QUEEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000111110000000L, Hand.KING_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000001111100000000L, Hand.ACE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000001000000001111L, Hand.CLUBS_FIVE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000000011111L, Hand.CLUBS_SIX_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000000111110L, Hand.CLUBS_SEVEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000001111100L, Hand.CLUBS_EIGHT_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000011111000L, Hand.CLUBS_NINE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000000111110000L, Hand.CLUBS_TEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000001111100000L, Hand.CLUBS_JACK_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000011111000000L, Hand.CLUBS_QUEEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000000111110000000L, Hand.CLUBS_KING_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000000001111100000000L, Hand.CLUBS_ACE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000010000000011110000000000000L, Hand.DIAMONDS_FIVE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000000111110000000000000L, Hand.DIAMONDS_SIX_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000001111100000000000000L, Hand.DIAMONDS_SEVEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000011111000000000000000L, Hand.DIAMONDS_EIGHT_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000000111110000000000000000L, Hand.DIAMONDS_NINE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000001111100000000000000000L, Hand.DIAMONDS_TEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000011111000000000000000000L, Hand.DIAMONDS_JACK_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000000111110000000000000000000L, Hand.DIAMONDS_QUEEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000001111100000000000000000000L, Hand.DIAMONDS_KING_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000000000011111000000000000000000000L, Hand.DIAMONDS_ACE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000100000000111100000000000000000000000000L, Hand.HEARTS_FIVE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000001111100000000000000000000000000L, Hand.HEARTS_SIX_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000011111000000000000000000000000000L, Hand.HEARTS_SEVEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000000111110000000000000000000000000000L, Hand.HEARTS_EIGHT_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000001111100000000000000000000000000000L, Hand.HEARTS_NINE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000011111000000000000000000000000000000L, Hand.HEARTS_TEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000000111110000000000000000000000000000000L, Hand.HEARTS_JACK_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000001111100000000000000000000000000000000L, Hand.HEARTS_QUEEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000011111000000000000000000000000000000000L, Hand.HEARTS_KING_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000000000111110000000000000000000000000000000000L, Hand.HEARTS_ACE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b1000000001111000000000000000000000000000000000000000L, Hand.SPADES_FIVE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000011111000000000000000000000000000000000000000L, Hand.SPADES_SIX_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000000111110000000000000000000000000000000000000000L, Hand.SPADES_SEVEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000001111100000000000000000000000000000000000000000L, Hand.SPADES_EIGHT_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000011111000000000000000000000000000000000000000000L, Hand.SPADES_NINE_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0000111110000000000000000000000000000000000000000000L, Hand.SPADES_TEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0001111100000000000000000000000000000000000000000000L, Hand.SPADES_JACK_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0011111000000000000000000000000000000000000000000000L, Hand.SPADES_QUEEN_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b0111110000000000000000000000000000000000000000000000L, Hand.SPADES_KING_HIGH_STRAIGHT_FLUSH);
        assertEquals(0b1111100000000000000000000000000000000000000000000000L, Hand.SPADES_ACE_HIGH_STRAIGHT_FLUSH);
    }

    @Test
    public void toLongNotation() {
        assertEquals("High card with kicker Ace", Hand.toLongNotation(Hand.toHand("Ah")));
        assertEquals("High card with kicker Ace and Queen", Hand.toLongNotation(Hand.toHand("QdAh")));
        assertEquals("High card with kicker Ace, Queen and Ten", Hand.toLongNotation(Hand.toHand("TcQdAh")));
        assertEquals("High card with kicker Ace, Queen, Ten and Eight", Hand.toLongNotation(Hand.toHand("8sTcQdAh")));
        assertEquals("High card with kicker Ace, Queen, Ten, Eight and Six", Hand.toLongNotation(Hand.toHand("6h8sTcQdAh")));
        assertEquals("High card with kicker Ace, Queen, Ten, Eight and Six", Hand.toLongNotation(Hand.toHand("4d6h8sTcQdAh")));
        assertEquals("High card with kicker Ace, Queen, Ten, Eight and Six", Hand.toLongNotation(Hand.toHand("2c4d6h8sTcQdAh")));
        assertEquals("One pair of Twos", Hand.toLongNotation(Hand.toHand("2c2d")));
        assertEquals("One pair of Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2dAh")));
        assertEquals("One pair of Twos with kicker Ace and Queen", Hand.toLongNotation(Hand.toHand("2c2dQdAh")));
        assertEquals("One pair of Twos with kicker Ace, Queen and Ten", Hand.toLongNotation(Hand.toHand("2c2dTcQdAh")));
        assertEquals("One pair of Twos with kicker Ace, Queen and Ten", Hand.toLongNotation(Hand.toHand("2c2d8sTcQdAh")));
        assertEquals("One pair of Twos with kicker Ace, Queen and Ten", Hand.toLongNotation(Hand.toHand("2c2d6h8sTcQdAh")));
        assertEquals("Two pair of Sixes and Twos", Hand.toLongNotation(Hand.toHand("2c2d6h6s")));
        assertEquals("Two pair of Sixes and Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d6h6sAh")));
        assertEquals("Two pair of Sixes and Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d6h6sQdAh")));
        assertEquals("Two pair of Sixes and Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d6h6sTcQdAh")));
        assertEquals("Trips of Twos", Hand.toLongNotation(Hand.toHand("2c2d2h")));
        assertEquals("Trips of Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d2hAh")));
        assertEquals("Trips of Twos with kicker Ace and Queen", Hand.toLongNotation(Hand.toHand("2c2d2hQdAh")));
        assertEquals("Trips of Twos with kicker Ace and Queen", Hand.toLongNotation(Hand.toHand("2c2d2hTcQdAh")));
        assertEquals("Trips of Twos with kicker Ace and Queen", Hand.toLongNotation(Hand.toHand("2c2d2h6sTcQdAh")));
        assertEquals("Six-high Straight", Hand.toLongNotation(Hand.toHand("2c3d4h5s6c")));
        assertEquals("Six-high Straight", Hand.toLongNotation(Hand.toHand("2c3d4h5s6cAh")));
        assertEquals("Six-high Straight", Hand.toLongNotation(Hand.toHand("2c3d4h5s6cQdAh")));
        assertEquals("Ten-high Flush", Hand.toLongNotation(Hand.toHand("2c4c6c8cTc")));
        assertEquals("Ten-high Flush", Hand.toLongNotation(Hand.toHand("2c4c6c8cTcAd")));
        assertEquals("Ten-high Flush", Hand.toLongNotation(Hand.toHand("2c4c6c8cTcQdAd")));
        assertEquals("Full house of Twos and Sixes", Hand.toLongNotation(Hand.toHand("2c2d2h6s6c")));
        assertEquals("Full house of Twos and Sixes", Hand.toLongNotation(Hand.toHand("2c2d2h6s6cAh")));
        assertEquals("Full house of Twos and Sixes", Hand.toLongNotation(Hand.toHand("2c2d2h6s6cQdAh")));
        assertEquals("Quads of Twos", Hand.toLongNotation(Hand.toHand("2c2d2h2s")));
        assertEquals("Quads of Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d2h2sAh")));
        assertEquals("Quads of Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d2h2sQdAh")));
        assertEquals("Quads of Twos with kicker Ace", Hand.toLongNotation(Hand.toHand("2c2d2h2s6cQdAh")));
        assertEquals("Six-high Straight flush", Hand.toLongNotation(Hand.toHand("2c3c4c5c6c")));
        assertEquals("Six-high Straight flush", Hand.toLongNotation(Hand.toHand("2c3c4c5c6cAd")));
        assertEquals("Six-high Straight flush", Hand.toLongNotation(Hand.toHand("2c3c4c5c6cQdAd")));
    }

    @Test
    public void rankToLogNotation() {
        assertEquals("Two", Hand.rankToLogNotationSingular(Hand.toHand("2c")));
        assertEquals("Three", Hand.rankToLogNotationSingular(Hand.toHand("3c")));
        assertEquals("Four", Hand.rankToLogNotationSingular(Hand.toHand("4c")));
        assertEquals("Five", Hand.rankToLogNotationSingular(Hand.toHand("5c")));
        assertEquals("Six", Hand.rankToLogNotationSingular(Hand.toHand("6c")));
        assertEquals("Seven", Hand.rankToLogNotationSingular(Hand.toHand("7c")));
        assertEquals("Eight", Hand.rankToLogNotationSingular(Hand.toHand("8c")));
        assertEquals("Nine", Hand.rankToLogNotationSingular(Hand.toHand("9c")));
        assertEquals("Ten", Hand.rankToLogNotationSingular(Hand.toHand("Tc")));
        assertEquals("Jack", Hand.rankToLogNotationSingular(Hand.toHand("Jc")));
        assertEquals("Queen", Hand.rankToLogNotationSingular(Hand.toHand("Qc")));
        assertEquals("King", Hand.rankToLogNotationSingular(Hand.toHand("Kc")));
        assertEquals("Ace", Hand.rankToLogNotationSingular(Hand.toHand("Ac")));

        assertEquals("Twos", Hand.rankToLogNotationPlural(Hand.toHand("2c2d")));
        assertEquals("Threes", Hand.rankToLogNotationPlural(Hand.toHand("3c3d")));
        assertEquals("Fours", Hand.rankToLogNotationPlural(Hand.toHand("4c4d")));
        assertEquals("Fives", Hand.rankToLogNotationPlural(Hand.toHand("5c5d")));
        assertEquals("Sixes", Hand.rankToLogNotationPlural(Hand.toHand("6c6d")));
        assertEquals("Sevens", Hand.rankToLogNotationPlural(Hand.toHand("7c7d")));
        assertEquals("Eights", Hand.rankToLogNotationPlural(Hand.toHand("8c8d")));
        assertEquals("Nines", Hand.rankToLogNotationPlural(Hand.toHand("9c9d")));
        assertEquals("Tens", Hand.rankToLogNotationPlural(Hand.toHand("TcTd")));
        assertEquals("Jacks", Hand.rankToLogNotationPlural(Hand.toHand("JcJd")));
        assertEquals("Queens", Hand.rankToLogNotationPlural(Hand.toHand("QcQd")));
        assertEquals("Kings", Hand.rankToLogNotationPlural(Hand.toHand("KcKd")));
        assertEquals("Aces", Hand.rankToLogNotationPlural(Hand.toHand("AcAd")));

        assertEquals("Two", Hand.rankToLogNotationSingular(Hand.toHand("2c2d")));
        assertEquals("Three", Hand.rankToLogNotationSingular(Hand.toHand("3c3d")));
        assertEquals("Four", Hand.rankToLogNotationSingular(Hand.toHand("4c4d")));
        assertEquals("Five", Hand.rankToLogNotationSingular(Hand.toHand("5c5d")));
        assertEquals("Six", Hand.rankToLogNotationSingular(Hand.toHand("6c6d")));
        assertEquals("Seven", Hand.rankToLogNotationSingular(Hand.toHand("7c7d")));
        assertEquals("Eight", Hand.rankToLogNotationSingular(Hand.toHand("8c8d")));
        assertEquals("Nine", Hand.rankToLogNotationSingular(Hand.toHand("9c9d")));
        assertEquals("Ten", Hand.rankToLogNotationSingular(Hand.toHand("TcTd")));
        assertEquals("Jack", Hand.rankToLogNotationSingular(Hand.toHand("JcJd")));
        assertEquals("Queen", Hand.rankToLogNotationSingular(Hand.toHand("QcQd")));
        assertEquals("King", Hand.rankToLogNotationSingular(Hand.toHand("KcKd")));
        assertEquals("Ace", Hand.rankToLogNotationSingular(Hand.toHand("AcAd")));
    }
}
