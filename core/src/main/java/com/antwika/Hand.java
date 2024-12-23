package com.antwika;

public class Hand {
    public static long DECK = 0b1111111111111111111111111111111111111111111111111111L;
    public static long NONE = 0b0000000000000L;
    public static long RANK = 0b1111111111111L;
    public static long TYPE = 0b111111111000000000000000000000000000000000000000L;
    public static long MAJOR = 0b000000000111111111111100000000000000000000000000L;
    public static long MINOR = 0b000000000000000000000011111111111110000000000000L;
    public static long KICKERS = 0b000000000000000000000000000000000001111111111111L;
    public static long HIGH_CARD = 0b000000001L;
    public static long ONE_PAIR = 0b000000010L;
    public static long TWO_PAIR = 0b000000100L;
    public static long TRIPS = 0b000001000L;
    public static long STRAIGHT = 0b000010000L;
    public static long FLUSH = 0b000100000L;
    public static long FULL_HOUSE = 0b001000000L;
    public static long QUADS = 0b010000000L;
    public static long STRAIGHT_FLUSH = 0b100000000L;
    public static long KICKER = 0b00000000000001111111111111L;
    public static long TWO = 0b0000000000001L;
    public static long THREE = 0b0000000000010L;
    public static long FOUR = 0b0000000000100L;
    public static long FIVE = 0b0000000001000L;
    public static long SIX = 0b0000000010000L;
    public static long SEVEN = 0b0000000100000L;
    public static long EIGHT = 0b0000001000000L;
    public static long NINE = 0b0000010000000L;
    public static long TEN = 0b0000100000000L;
    public static long JACK = 0b0001000000000L;
    public static long QUEEN = 0b0010000000000L;
    public static long KING = 0b0100000000000L;
    public static long ACE = 0b1000000000000L;
    public static long CLUBS_TWO = 0b0000000000001L;
    public static long CLUBS_THREE = 0b0000000000010L;
    public static long CLUBS_FOUR = 0b0000000000100L;
    public static long CLUBS_FIVE = 0b0000000001000L;
    public static long CLUBS_SIX = 0b0000000010000L;
    public static long CLUBS_SEVEN = 0b0000000100000L;
    public static long CLUBS_EIGHT = 0b0000001000000L;
    public static long CLUBS_NINE = 0b0000010000000L;
    public static long CLUBS_TEN = 0b0000100000000L;
    public static long CLUBS_JACK = 0b0001000000000L;
    public static long CLUBS_QUEEN = 0b0010000000000L;
    public static long CLUBS_KING = 0b0100000000000L;
    public static long CLUBS_ACE = 0b1000000000000L;
    public static long DIAMONDS_TWO = 0b0000000000001L << 13;
    public static long DIAMONDS_THREE = 0b0000000000010L << 13;
    public static long DIAMONDS_FOUR = 0b0000000000100L << 13;
    public static long DIAMONDS_FIVE = 0b0000000001000L << 13;
    public static long DIAMONDS_SIX = 0b0000000010000L << 13;
    public static long DIAMONDS_SEVEN = 0b0000000100000L << 13;
    public static long DIAMONDS_EIGHT = 0b0000001000000L << 13;
    public static long DIAMONDS_NINE = 0b0000010000000L << 13;
    public static long DIAMONDS_TEN = 0b0000100000000L << 13;
    public static long DIAMONDS_JACK = 0b0001000000000L << 13;
    public static long DIAMONDS_QUEEN = 0b0010000000000L << 13;
    public static long DIAMONDS_KING = 0b0100000000000L << 13;
    public static long DIAMONDS_ACE = 0b1000000000000L << 13;
    public static long HEARTS_TWO = 0b0000000000001L << 26;
    public static long HEARTS_THREE = 0b0000000000010L << 26;
    public static long HEARTS_FOUR = 0b0000000000100L << 26;
    public static long HEARTS_FIVE = 0b0000000001000L << 26;
    public static long HEARTS_SIX = 0b0000000010000L << 26;
    public static long HEARTS_SEVEN = 0b0000000100000L << 26;
    public static long HEARTS_EIGHT = 0b0000001000000L << 26;
    public static long HEARTS_NINE = 0b0000010000000L << 26;
    public static long HEARTS_TEN = 0b0000100000000L << 26;
    public static long HEARTS_JACK = 0b0001000000000L << 26;
    public static long HEARTS_QUEEN = 0b0010000000000L << 26;
    public static long HEARTS_KING = 0b0100000000000L << 26;
    public static long HEARTS_ACE = 0b1000000000000L << 26;
    public static long SPADES_TWO = 0b0000000000001L << 39;
    public static long SPADES_THREE = 0b0000000000010L << 39;
    public static long SPADES_FOUR = 0b0000000000100L << 39;
    public static long SPADES_FIVE = 0b0000000001000L << 39;
    public static long SPADES_SIX = 0b0000000010000L << 39;
    public static long SPADES_SEVEN = 0b0000000100000L << 39;
    public static long SPADES_EIGHT = 0b0000001000000L << 39;
    public static long SPADES_NINE = 0b0000010000000L << 39;
    public static long SPADES_TEN = 0b0000100000000L << 39;
    public static long SPADES_JACK = 0b0001000000000L << 39;
    public static long SPADES_QUEEN = 0b0010000000000L << 39;
    public static long SPADES_KING = 0b0100000000000L << 39;
    public static long SPADES_ACE = 0b1000000000000L << 39;
    public static long SUIT = 0b1111111111111L;
    public static long CLUBS = SUIT;
    public static long DIAMONDS = SUIT << 13;
    public static long HEARTS = SUIT << 26;
    public static long SPADES = SUIT << 39;
    public static long TWOS = TWO | (TWO << 13) | (TWO << 26) | (TWO << 39);
    public static long THREES = TWOS << 1;
    public static long FOURS = TWOS << 2;
    public static long FIVES = TWOS << 3;
    public static long SIXES = TWOS << 4;
    public static long SEVENS = TWOS << 5;
    public static long EIGHTS = TWOS << 6;
    public static long NINES = TWOS << 7;
    public static long TENS = TWOS << 8;
    public static long JACKS = TWOS << 9;
    public static long QUEENS = TWOS << 10;
    public static long KINGS = TWOS << 11;
    public static long ACES = TWOS << 12;
    public static long FIVE_HIGH_STRAIGHT_FLUSH = 0b1000000001111L;
    public static long SIX_HIGH_STRAIGHT_FLUSH = 0b0000000011111L;
    public static long SEVEN_HIGH_STRAIGHT_FLUSH = 0b0000000111110L;
    public static long EIGHT_HIGH_STRAIGHT_FLUSH = 0b0000001111100L;
    public static long NINE_HIGH_STRAIGHT_FLUSH = 0b0000011111000L;
    public static long TEN_HIGH_STRAIGHT_FLUSH = 0b0000111110000L;
    public static long JACK_HIGH_STRAIGHT_FLUSH = 0b0001111100000L;
    public static long QUEEN_HIGH_STRAIGHT_FLUSH = 0b0011111000000L;
    public static long KING_HIGH_STRAIGHT_FLUSH = 0b0111110000000L;
    public static long ACE_HIGH_STRAIGHT_FLUSH = 0b1111100000000L;
    public static long CLUBS_FIVE_HIGH_STRAIGHT_FLUSH = FIVE_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_SIX_HIGH_STRAIGHT_FLUSH = SIX_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_SEVEN_HIGH_STRAIGHT_FLUSH = SEVEN_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_EIGHT_HIGH_STRAIGHT_FLUSH = EIGHT_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_NINE_HIGH_STRAIGHT_FLUSH = NINE_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_TEN_HIGH_STRAIGHT_FLUSH = TEN_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_JACK_HIGH_STRAIGHT_FLUSH = JACK_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_QUEEN_HIGH_STRAIGHT_FLUSH = QUEEN_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_KING_HIGH_STRAIGHT_FLUSH = KING_HIGH_STRAIGHT_FLUSH;
    public static long CLUBS_ACE_HIGH_STRAIGHT_FLUSH = ACE_HIGH_STRAIGHT_FLUSH;
    public static long DIAMONDS_FIVE_HIGH_STRAIGHT_FLUSH = FIVE_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_SIX_HIGH_STRAIGHT_FLUSH = SIX_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_SEVEN_HIGH_STRAIGHT_FLUSH = SEVEN_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_EIGHT_HIGH_STRAIGHT_FLUSH = EIGHT_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_NINE_HIGH_STRAIGHT_FLUSH = NINE_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_TEN_HIGH_STRAIGHT_FLUSH = TEN_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_JACK_HIGH_STRAIGHT_FLUSH = JACK_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_QUEEN_HIGH_STRAIGHT_FLUSH = QUEEN_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_KING_HIGH_STRAIGHT_FLUSH = KING_HIGH_STRAIGHT_FLUSH << 13;
    public static long DIAMONDS_ACE_HIGH_STRAIGHT_FLUSH = ACE_HIGH_STRAIGHT_FLUSH << 13;
    public static long HEARTS_FIVE_HIGH_STRAIGHT_FLUSH = FIVE_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_SIX_HIGH_STRAIGHT_FLUSH = SIX_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_SEVEN_HIGH_STRAIGHT_FLUSH = SEVEN_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_EIGHT_HIGH_STRAIGHT_FLUSH = EIGHT_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_NINE_HIGH_STRAIGHT_FLUSH = NINE_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_TEN_HIGH_STRAIGHT_FLUSH = TEN_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_JACK_HIGH_STRAIGHT_FLUSH = JACK_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_QUEEN_HIGH_STRAIGHT_FLUSH = QUEEN_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_KING_HIGH_STRAIGHT_FLUSH = KING_HIGH_STRAIGHT_FLUSH << 26;
    public static long HEARTS_ACE_HIGH_STRAIGHT_FLUSH = ACE_HIGH_STRAIGHT_FLUSH << 26;
    public static long SPADES_FIVE_HIGH_STRAIGHT_FLUSH = FIVE_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_SIX_HIGH_STRAIGHT_FLUSH = SIX_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_SEVEN_HIGH_STRAIGHT_FLUSH = SEVEN_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_EIGHT_HIGH_STRAIGHT_FLUSH = EIGHT_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_NINE_HIGH_STRAIGHT_FLUSH = NINE_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_TEN_HIGH_STRAIGHT_FLUSH = TEN_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_JACK_HIGH_STRAIGHT_FLUSH = JACK_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_QUEEN_HIGH_STRAIGHT_FLUSH = QUEEN_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_KING_HIGH_STRAIGHT_FLUSH = KING_HIGH_STRAIGHT_FLUSH << 39;
    public static long SPADES_ACE_HIGH_STRAIGHT_FLUSH = ACE_HIGH_STRAIGHT_FLUSH << 39;

    public static long highestBits(long val, int maxBits) {
        int count = 0;
        long result = 0;

        for (int i = 12; i >= 0; i--) {
            if (((val >> i) & 0b1L) > 0L) {
                result += 0b1L << i;
                count++;
            }

            if (count >= maxBits) break;
        }

        return result;
    }

    public static long value(long hand, long type, long major, long minor) {
        final var kickers = RANK & (hand | (hand >> 13) | (hand >> 26) | (hand >> 39)) & (RANK & ~major) & (RANK & ~minor);

        long val = (type << 39) | (major << 26) | (minor << 13);

        if (type == STRAIGHT_FLUSH) val |= highestBits(kickers, 0);
        if (type == QUADS) val |= highestBits(kickers, 1);
        if (type == FULL_HOUSE) val |= highestBits(kickers, 0);
        if (type == FLUSH) val |= highestBits(kickers, 0);
        if (type == STRAIGHT) val |= highestBits(kickers, 0);
        if (type == TRIPS) val |= highestBits(kickers, 2);
        if (type == TWO_PAIR) val |= highestBits(kickers, 1);
        if (type == ONE_PAIR) val |= highestBits(kickers, 3);
        if (type == HIGH_CARD) val |= highestBits(kickers, 5);

        return val;
    }

    public static long valueFromHand(long hand) {
        if (isStraightFlush(hand) > 0L) return isStraightFlush(hand);
        if (isQuads(hand) > 0L) return isQuads(hand);
        if (isFullHouse(hand) > 0L) return isFullHouse(hand);
        if (isFlush(hand) > 0L) return isFlush(hand);
        if (isStraight(hand) > 0L) return isStraight(hand);
        if (isTrips(hand) > 0L) return isTrips(hand);
        if (isTwoPair(hand) > 0L) return isTwoPair(hand);
        if (isOnePair(hand) > 0L) return isOnePair(hand);
        if (isHighCard(hand) > 0L) return isHighCard(hand);
        return NONE;
    }

    public static long type(long hand) {
        if (isStraightFlush(hand) > 0L) return STRAIGHT_FLUSH;
        if (isQuads(hand) > 0L) return QUADS;
        if (isFullHouse(hand) > 0L) return FULL_HOUSE;
        if (isFlush(hand) > 0L) return FLUSH;
        if (isStraight(hand) > 0L) return STRAIGHT;
        if (isTrips(hand) > 0L) return TRIPS;
        if (isTwoPair(hand) > 0L) return TWO_PAIR;
        if (isOnePair(hand) > 0L) return ONE_PAIR;
        if (isHighCard(hand) > 0L) return HIGH_CARD;
        return NONE;
    }

    public static String print(long hand) {
        return "";
    }

    public static long isStraightFlush(long hand) {
        if ((hand & CLUBS_ACE_HIGH_STRAIGHT_FLUSH) == CLUBS_ACE_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_ACE_HIGH_STRAIGHT_FLUSH) == DIAMONDS_ACE_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_ACE_HIGH_STRAIGHT_FLUSH) == HEARTS_ACE_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_ACE_HIGH_STRAIGHT_FLUSH) == SPADES_ACE_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, ACE, NONE);

        if ((hand & CLUBS_KING_HIGH_STRAIGHT_FLUSH) == CLUBS_KING_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_KING_HIGH_STRAIGHT_FLUSH) == DIAMONDS_KING_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_KING_HIGH_STRAIGHT_FLUSH) == HEARTS_KING_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_KING_HIGH_STRAIGHT_FLUSH) == SPADES_KING_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, KING, NONE);

        if ((hand & CLUBS_QUEEN_HIGH_STRAIGHT_FLUSH) == CLUBS_QUEEN_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_QUEEN_HIGH_STRAIGHT_FLUSH) == DIAMONDS_QUEEN_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_QUEEN_HIGH_STRAIGHT_FLUSH) == HEARTS_QUEEN_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_QUEEN_HIGH_STRAIGHT_FLUSH) == SPADES_QUEEN_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, QUEEN, NONE);

        if ((hand & CLUBS_JACK_HIGH_STRAIGHT_FLUSH) == CLUBS_JACK_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_JACK_HIGH_STRAIGHT_FLUSH) == DIAMONDS_JACK_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_JACK_HIGH_STRAIGHT_FLUSH) == HEARTS_JACK_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_JACK_HIGH_STRAIGHT_FLUSH) == SPADES_JACK_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, JACK, NONE);

        if ((hand & CLUBS_TEN_HIGH_STRAIGHT_FLUSH) == CLUBS_TEN_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_TEN_HIGH_STRAIGHT_FLUSH) == DIAMONDS_TEN_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_TEN_HIGH_STRAIGHT_FLUSH) == HEARTS_TEN_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_TEN_HIGH_STRAIGHT_FLUSH) == SPADES_TEN_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, TEN, NONE);

        if ((hand & CLUBS_NINE_HIGH_STRAIGHT_FLUSH) == CLUBS_NINE_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_NINE_HIGH_STRAIGHT_FLUSH) == DIAMONDS_NINE_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_NINE_HIGH_STRAIGHT_FLUSH) == HEARTS_NINE_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_NINE_HIGH_STRAIGHT_FLUSH) == SPADES_NINE_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, NINE, NONE);

        if ((hand & CLUBS_EIGHT_HIGH_STRAIGHT_FLUSH) == CLUBS_EIGHT_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_EIGHT_HIGH_STRAIGHT_FLUSH) == DIAMONDS_EIGHT_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_EIGHT_HIGH_STRAIGHT_FLUSH) == HEARTS_EIGHT_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_EIGHT_HIGH_STRAIGHT_FLUSH) == SPADES_EIGHT_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, EIGHT, NONE);

        if ((hand & CLUBS_SEVEN_HIGH_STRAIGHT_FLUSH) == CLUBS_SEVEN_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_SEVEN_HIGH_STRAIGHT_FLUSH) == DIAMONDS_SEVEN_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_SEVEN_HIGH_STRAIGHT_FLUSH) == HEARTS_SEVEN_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_SEVEN_HIGH_STRAIGHT_FLUSH) == SPADES_SEVEN_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, SEVEN, NONE);

        if ((hand & CLUBS_SIX_HIGH_STRAIGHT_FLUSH) == CLUBS_SIX_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_SIX_HIGH_STRAIGHT_FLUSH) == DIAMONDS_SIX_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_SIX_HIGH_STRAIGHT_FLUSH) == HEARTS_SIX_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_SIX_HIGH_STRAIGHT_FLUSH) == SPADES_SIX_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, SIX, NONE);

        if ((hand & CLUBS_FIVE_HIGH_STRAIGHT_FLUSH) == CLUBS_FIVE_HIGH_STRAIGHT_FLUSH ||
            (hand & DIAMONDS_FIVE_HIGH_STRAIGHT_FLUSH) == DIAMONDS_FIVE_HIGH_STRAIGHT_FLUSH ||
            (hand & HEARTS_FIVE_HIGH_STRAIGHT_FLUSH) == HEARTS_FIVE_HIGH_STRAIGHT_FLUSH ||
            (hand & SPADES_FIVE_HIGH_STRAIGHT_FLUSH) == SPADES_FIVE_HIGH_STRAIGHT_FLUSH)
            return value(NONE, STRAIGHT_FLUSH, FIVE, NONE);

        return value(NONE, NONE, NONE, NONE);
    }

    public static long isQuads(long hand) {
        if (isStraightFlush(hand) > 0L) return value(NONE, NONE, NONE, NONE);
        if ((hand & ACES) == ACES) return value(hand, QUADS, ACE, NONE);
        if ((hand & KINGS) == KINGS) return value(hand, QUADS, KING, NONE);
        if ((hand & QUEENS) == QUEENS) return value(hand, QUADS, QUEEN, NONE);
        if ((hand & JACKS) == JACKS) return value(hand, QUADS, JACK, NONE);
        if ((hand & TENS) == TENS) return value(hand, QUADS, TEN, NONE);
        if ((hand & NINES) == NINES) return value(hand, QUADS, NINE, NONE);
        if ((hand & EIGHTS) == EIGHTS) return value(hand, QUADS, EIGHT, NONE);
        if ((hand & SEVENS) == SEVENS) return value(hand, QUADS, SEVEN, NONE);
        if ((hand & SIXES) == SIXES) return value(hand, QUADS, SIX, NONE);
        if ((hand & FIVES) == FIVES) return value(hand, QUADS, FIVE, NONE);
        if ((hand & FOURS) == FOURS) return value(hand, QUADS, FOUR, NONE);
        if ((hand & THREES) == THREES) return value(hand, QUADS, THREE, NONE);
        if ((hand & TWOS) == TWOS) return value(hand, QUADS, TWO, NONE);
        return value(NONE, NONE, NONE, NONE);
    }

    public static long isFullHouse(long hand) {
        if (isQuads(hand) > 0L) return value(NONE, NONE, NONE, NONE);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, KING);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, QUEEN);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, JACK);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, TEN);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, ACE, NINE);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, EIGHT);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, SEVEN);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, ACE, SIX);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, ACE, FIVE);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, FOUR);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, ACE, THREE);
        if (Long.bitCount(hand & ACES) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, ACE, TWO);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, KING, ACE);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, KING, QUEEN);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, KING, JACK);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, KING, TEN);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, KING, NINE);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, KING, EIGHT);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, KING, SEVEN);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, KING, SIX);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, KING, FIVE);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, KING, FOUR);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, KING, THREE);
        if (Long.bitCount(hand & KINGS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, KING, TWO);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, ACE);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, KING);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, JACK);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, TEN);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, NINE);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, EIGHT);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, SEVEN);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, SIX);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, FIVE);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, FOUR);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, THREE);
        if (Long.bitCount(hand & QUEENS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, QUEEN, TWO);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, JACK, ACE);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, KING);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, QUEEN);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, TEN);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, JACK, NINE);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, EIGHT);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, SEVEN);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, JACK, SIX);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, JACK, FIVE);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, FOUR);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, JACK, THREE);
        if (Long.bitCount(hand & JACKS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, JACK, TWO);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, TEN, ACE);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, KING);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, QUEEN);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, JACK);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, TEN, NINE);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, EIGHT);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, SEVEN);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, TEN, SIX);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, TEN, FIVE);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, FOUR);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, TEN, THREE);
        if (Long.bitCount(hand & TENS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, TEN, TWO);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, NINE, ACE);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, KING);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, QUEEN);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, JACK);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, TEN);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, EIGHT);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, SEVEN);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, NINE, SIX);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, NINE, FIVE);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, FOUR);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, NINE, THREE);
        if (Long.bitCount(hand & NINES) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, NINE, TWO);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, ACE);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, KING);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, QUEEN);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, JACK);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, TEN);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, NINE);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, SEVEN);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, SIX);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, FIVE);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, FOUR);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, THREE);
        if (Long.bitCount(hand & EIGHTS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, EIGHT, TWO);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, ACE);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, KING);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, QUEEN);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, JACK);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, TEN);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, NINE);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, EIGHT);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, SIX);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, FIVE);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, FOUR);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, THREE);
        if (Long.bitCount(hand & SEVENS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, SEVEN, TWO);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, SIX, ACE);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, KING);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, QUEEN);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, JACK);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, TEN);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, SIX, NINE);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, EIGHT);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, SEVEN);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, SIX, FIVE);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, FOUR);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, SIX, THREE);
        if (Long.bitCount(hand & SIXES) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, SIX, TWO);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, ACE);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, KING);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, QUEEN);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, JACK);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, TEN);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, NINE);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, EIGHT);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, SEVEN);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, SIX);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, FOUR);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, THREE);
        if (Long.bitCount(hand & FIVES) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, FIVE, TWO);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, ACE);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, KING);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, QUEEN);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, JACK);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, TEN);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, NINE);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, EIGHT);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, SEVEN);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, SIX);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, FIVE);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, THREE);
        if (Long.bitCount(hand & FOURS) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, FOUR, TWO);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, THREE, ACE);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, KING);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, QUEEN);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, JACK);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, TEN);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, THREE, NINE);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, EIGHT);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, SEVEN);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, THREE, SIX);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, THREE, FIVE);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, FOUR);
        if (Long.bitCount(hand & THREES) == 3 && Long.bitCount(hand & TWOS) >= 2)
            return value(NONE, FULL_HOUSE, THREE, TWO);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & ACES) >= 2)
            return value(NONE, FULL_HOUSE, TWO, ACE);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & KINGS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, KING);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & QUEENS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, QUEEN);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & JACKS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, JACK);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & TENS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, TEN);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & NINES) >= 2)
            return value(NONE, FULL_HOUSE, TWO, NINE);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, EIGHT);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & SEVENS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, SEVEN);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & SIXES) >= 2)
            return value(NONE, FULL_HOUSE, TWO, SIX);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & FIVES) >= 2)
            return value(NONE, FULL_HOUSE, TWO, FIVE);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & FOURS) >= 2)
            return value(NONE, FULL_HOUSE, TWO, FOUR);
        if (Long.bitCount(hand & TWOS) == 3 && Long.bitCount(hand & THREES) >= 2)
            return value(NONE, FULL_HOUSE, TWO, THREE);
        return value(NONE, NONE, NONE, NONE);
    }

    public static long isFlush(long hand) {
        if (isFullHouse(hand) > 0L) return value(NONE, NONE, NONE, NONE);

        for (int i = 12; i >= 3; i--) {
            long rank = (0b1L << i);
            if (Long.bitCount(hand & CLUBS) >= 5 && (hand & rank) > 0L) return value(NONE, FLUSH, rank, NONE);
            if (Long.bitCount(hand & DIAMONDS) >= 5 && ((hand >> 13) & rank) > 0L)
                return value(NONE, FLUSH, rank, NONE);
            if (Long.bitCount(hand & HEARTS) >= 5 && ((hand >> 26) & rank) > 0L) return value(NONE, FLUSH, rank, NONE);
            if (Long.bitCount(hand & SPADES) >= 5 && ((hand >> 39) & rank) > 0L) return value(NONE, FLUSH, rank, NONE);
        }

        return value(NONE, NONE, NONE, NONE);
    }

    public static long isStraight(long hand) {
        if (isFlush(hand) > 0L) return value(NONE, NONE, NONE, NONE);

        if ((hand & TENS) > 0L && (hand & JACKS) > 0L && (hand & QUEENS) > 0L && (hand & KINGS) > 0L && (hand & ACES) > 0L)
            return value(NONE, STRAIGHT, ACE, NONE);
        if ((hand & NINES) > 0L && (hand & TENS) > 0L && (hand & JACKS) > 0L && (hand & QUEENS) > 0L && (hand & KINGS) > 0L)
            return value(NONE, STRAIGHT, KING, NONE);
        if ((hand & EIGHTS) > 0L && (hand & NINES) > 0L && (hand & TENS) > 0L && (hand & JACKS) > 0L && (hand & QUEENS) > 0L)
            return value(NONE, STRAIGHT, QUEEN, NONE);
        if ((hand & SEVENS) > 0L && (hand & EIGHTS) > 0L && (hand & NINES) > 0L && (hand & TENS) > 0L && (hand & JACKS) > 0L)
            return value(NONE, STRAIGHT, JACK, NONE);
        if ((hand & SIXES) > 0L && (hand & SEVENS) > 0L && (hand & EIGHTS) > 0L && (hand & NINES) > 0L && (hand & TENS) > 0L)
            return value(NONE, STRAIGHT, TEN, NONE);
        if ((hand & FIVES) > 0L && (hand & SIXES) > 0L && (hand & SEVENS) > 0L && (hand & EIGHTS) > 0L && (hand & NINES) > 0L)
            return value(NONE, STRAIGHT, NINE, NONE);
        if ((hand & FOURS) > 0L && (hand & FIVES) > 0L && (hand & SIXES) > 0L && (hand & SEVENS) > 0L && (hand & EIGHTS) > 0L)
            return value(NONE, STRAIGHT, EIGHT, NONE);
        if ((hand & THREES) > 0L && (hand & FOURS) > 0L && (hand & FIVES) > 0L && (hand & SIXES) > 0L && (hand & SEVENS) > 0L)
            return value(NONE, STRAIGHT, SEVEN, NONE);
        if ((hand & TWOS) > 0L && (hand & THREES) > 0L && (hand & FOURS) > 0L && (hand & FIVES) > 0L && (hand & SIXES) > 0L)
            return value(NONE, STRAIGHT, SIX, NONE);
        if ((hand & ACES) > 0L && (hand & TWOS) > 0L && (hand & THREES) > 0L && (hand & FOURS) > 0L && (hand & FIVES) > 0L)
            return value(NONE, STRAIGHT, FIVE, NONE);

        return value(NONE, NONE, NONE, NONE);
    }

    public static long isTrips(long hand) {
        if (isStraight(hand) > 0L) return value(NONE, NONE, NONE, NONE);
        if (Long.bitCount(hand & ACES) == 3) return value(hand, TRIPS, ACE, NONE);
        if (Long.bitCount(hand & KINGS) == 3) return value(hand, TRIPS, KING, NONE);
        if (Long.bitCount(hand & QUEENS) == 3) return value(hand, TRIPS, QUEEN, NONE);
        if (Long.bitCount(hand & JACKS) == 3) return value(hand, TRIPS, JACK, NONE);
        if (Long.bitCount(hand & TENS) == 3) return value(hand, TRIPS, TEN, NONE);
        if (Long.bitCount(hand & NINES) == 3) return value(hand, TRIPS, NINE, NONE);
        if (Long.bitCount(hand & EIGHTS) == 3) return value(hand, TRIPS, EIGHT, NONE);
        if (Long.bitCount(hand & SEVENS) == 3) return value(hand, TRIPS, SEVEN, NONE);
        if (Long.bitCount(hand & SIXES) == 3) return value(hand, TRIPS, SIX, NONE);
        if (Long.bitCount(hand & FIVES) == 3) return value(hand, TRIPS, FIVE, NONE);
        if (Long.bitCount(hand & FOURS) == 3) return value(hand, TRIPS, FOUR, NONE);
        if (Long.bitCount(hand & THREES) == 3) return value(hand, TRIPS, THREE, NONE);
        if (Long.bitCount(hand & TWOS) == 3) return value(hand, TRIPS, TWO, NONE);
        return value(NONE, NONE, NONE, NONE);
    }

    public static long isTwoPair(long hand) {
        if (isTrips(hand) > 0L) return value(NONE, NONE, NONE, NONE);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, ACE, KING);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, ACE, QUEEN);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, ACE, JACK);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & TENS) >= 2) return value(hand, TWO_PAIR, ACE, TEN);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, ACE, NINE);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, ACE, EIGHT);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, ACE, SEVEN);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & SIXES) >= 2) return value(hand, TWO_PAIR, ACE, SIX);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, ACE, FIVE);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, ACE, FOUR);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, ACE, THREE);
        if (Long.bitCount(hand & ACES) == 2 && Long.bitCount(hand & TWOS) >= 2) return value(hand, TWO_PAIR, ACE, TWO);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, KING, ACE);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, KING, QUEEN);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, KING, JACK);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, KING, TEN);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, KING, NINE);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, KING, EIGHT);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, KING, SEVEN);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, KING, SIX);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, KING, FIVE);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, KING, FOUR);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, KING, THREE);
        if (Long.bitCount(hand & KINGS) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, KING, TWO);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, QUEEN, ACE);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, KING);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, JACK);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, TEN);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, QUEEN, NINE);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, EIGHT);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, SEVEN);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, QUEEN, SIX);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, QUEEN, FIVE);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, FOUR);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, QUEEN, THREE);
        if (Long.bitCount(hand & QUEENS) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, QUEEN, TWO);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, JACK, ACE);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, JACK, KING);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, JACK, QUEEN);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, JACK, TEN);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, JACK, NINE);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, JACK, EIGHT);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, JACK, SEVEN);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, JACK, SIX);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, JACK, FIVE);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, JACK, FOUR);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, JACK, THREE);
        if (Long.bitCount(hand & JACKS) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, JACK, TWO);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & ACES) >= 2) return value(hand, TWO_PAIR, TEN, ACE);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, TEN, KING);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, TEN, QUEEN);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, TEN, JACK);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, TEN, NINE);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, TEN, EIGHT);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, TEN, SEVEN);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & SIXES) >= 2) return value(hand, TWO_PAIR, TEN, SIX);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, TEN, FIVE);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, TEN, FOUR);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, TEN, THREE);
        if (Long.bitCount(hand & TENS) == 2 && Long.bitCount(hand & TWOS) >= 2) return value(hand, TWO_PAIR, TEN, TWO);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, NINE, ACE);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, NINE, KING);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, NINE, QUEEN);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, NINE, JACK);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, NINE, TEN);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, NINE, EIGHT);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, NINE, SEVEN);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, NINE, SIX);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, NINE, FIVE);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, NINE, FOUR);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, NINE, THREE);
        if (Long.bitCount(hand & NINES) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, NINE, TWO);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, EIGHT, ACE);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, KING);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, QUEEN);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, JACK);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, TEN);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, EIGHT, NINE);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, SEVEN);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, EIGHT, SIX);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, EIGHT, FIVE);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, FOUR);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, EIGHT, THREE);
        if (Long.bitCount(hand & EIGHTS) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, EIGHT, TWO);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, SEVEN, ACE);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, KING);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, QUEEN);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, JACK);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, TEN);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, SEVEN, NINE);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, EIGHT);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, SEVEN, SIX);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, SEVEN, FIVE);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, FOUR);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, SEVEN, THREE);
        if (Long.bitCount(hand & SEVENS) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, SEVEN, TWO);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & ACES) >= 2) return value(hand, TWO_PAIR, SIX, ACE);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, SIX, KING);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, SIX, QUEEN);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, SIX, JACK);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & TENS) >= 2) return value(hand, TWO_PAIR, SIX, TEN);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, SIX, NINE);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, SIX, EIGHT);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, SIX, SEVEN);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, SIX, FIVE);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, SIX, FOUR);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, SIX, THREE);
        if (Long.bitCount(hand & SIXES) == 2 && Long.bitCount(hand & TWOS) >= 2) return value(hand, TWO_PAIR, SIX, TWO);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, FIVE, ACE);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, FIVE, KING);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, FIVE, QUEEN);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, FIVE, JACK);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, FIVE, TEN);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, FIVE, NINE);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, FIVE, EIGHT);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, FIVE, SEVEN);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, FIVE, SIX);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, FIVE, FOUR);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, FIVE, THREE);
        if (Long.bitCount(hand & FIVES) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, FIVE, TWO);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, FOUR, ACE);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, FOUR, KING);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, FOUR, QUEEN);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, FOUR, JACK);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, FOUR, TEN);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, FOUR, NINE);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, FOUR, EIGHT);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, FOUR, SEVEN);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, FOUR, SIX);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, FOUR, FIVE);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, FOUR, THREE);
        if (Long.bitCount(hand & FOURS) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, FOUR, TWO);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & ACES) >= 2)
            return value(hand, TWO_PAIR, THREE, ACE);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, THREE, KING);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, THREE, QUEEN);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, THREE, JACK);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & TENS) >= 2)
            return value(hand, TWO_PAIR, THREE, TEN);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, THREE, NINE);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, THREE, EIGHT);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, THREE, SEVEN);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & SIXES) >= 2)
            return value(hand, TWO_PAIR, THREE, SIX);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, THREE, FIVE);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, THREE, FOUR);
        if (Long.bitCount(hand & THREES) == 2 && Long.bitCount(hand & TWOS) >= 2)
            return value(hand, TWO_PAIR, THREE, TWO);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & ACES) >= 2) return value(hand, TWO_PAIR, TWO, ACE);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & KINGS) >= 2)
            return value(hand, TWO_PAIR, TWO, KING);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & QUEENS) >= 2)
            return value(hand, TWO_PAIR, TWO, QUEEN);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & JACKS) >= 2)
            return value(hand, TWO_PAIR, TWO, JACK);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & TENS) >= 2) return value(hand, TWO_PAIR, TWO, TEN);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & NINES) >= 2)
            return value(hand, TWO_PAIR, TWO, NINE);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & EIGHTS) >= 2)
            return value(hand, TWO_PAIR, TWO, EIGHT);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & SEVENS) >= 2)
            return value(hand, TWO_PAIR, TWO, SEVEN);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & SIXES) >= 2) return value(hand, TWO_PAIR, TWO, SIX);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & FIVES) >= 2)
            return value(hand, TWO_PAIR, TWO, FIVE);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & FOURS) >= 2)
            return value(hand, TWO_PAIR, TWO, FOUR);
        if (Long.bitCount(hand & TWOS) == 2 && Long.bitCount(hand & THREES) >= 2)
            return value(hand, TWO_PAIR, TWO, THREE);
        return value(NONE, NONE, NONE, NONE);
    }

    public static long isOnePair(long hand) {
        if (isTwoPair(hand) > 0L) return value(NONE, NONE, NONE, NONE);
        if (Long.bitCount(hand & ACES) == 2) return value(hand, ONE_PAIR, ACE, NONE);
        if (Long.bitCount(hand & KINGS) == 2) return value(hand, ONE_PAIR, KING, NONE);
        if (Long.bitCount(hand & QUEENS) == 2) return value(hand, ONE_PAIR, QUEEN, NONE);
        if (Long.bitCount(hand & JACKS) == 2) return value(hand, ONE_PAIR, JACK, NONE);
        if (Long.bitCount(hand & TENS) == 2) return value(hand, ONE_PAIR, TEN, NONE);
        if (Long.bitCount(hand & NINES) == 2) return value(hand, ONE_PAIR, NINE, NONE);
        if (Long.bitCount(hand & EIGHTS) == 2) return value(hand, ONE_PAIR, EIGHT, NONE);
        if (Long.bitCount(hand & SEVENS) == 2) return value(hand, ONE_PAIR, SEVEN, NONE);
        if (Long.bitCount(hand & SIXES) == 2) return value(hand, ONE_PAIR, SIX, NONE);
        if (Long.bitCount(hand & FIVES) == 2) return value(hand, ONE_PAIR, FIVE, NONE);
        if (Long.bitCount(hand & FOURS) == 2) return value(hand, ONE_PAIR, FOUR, NONE);
        if (Long.bitCount(hand & THREES) == 2) return value(hand, ONE_PAIR, THREE, NONE);
        if (Long.bitCount(hand & TWOS) == 2) return value(hand, ONE_PAIR, TWO, NONE);
        return value(NONE, NONE, NONE, NONE);
    }

    public static long isHighCard(long hand) {
        if (isOnePair(hand) > 0L) return value(NONE, NONE, NONE, NONE);
        return value(hand, HIGH_CARD, NONE, NONE);
    }

    public static long typeFromValue(long value) {
        return (value >> 39);
    }

    public static long majorFromValue(long value) {
        return (value >> 26) & RANK;
    }

    public static long minorFromValue(long value) {
        return (value >> 13) & RANK;
    }

    public static long kickersFromValue(long value) {
        return value & RANK;
    }

    public static String toSpacedNotation(String cards) {
        final var sb = new StringBuilder();
        for (int i = 2; i <= cards.length(); i += 2) {
            sb.append(cards, i - 2, i);
            if (i < cards.length()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String toNotation(long hand) {
        return toNotation(hand, "");
    }

    public static String toNotation(long hand, String delimiter) {
        final var ranks = "23456789TJQKA";
        final var suits = "cdhs";
        final var notation = new StringBuilder();
        for (int suit = 0; suit < 4; suit++) {
            for (int rank = 0; rank < 13; rank++) {
                int bit = suit * 13 + rank;
                if (((hand >> bit) & 0b1L) > 0L) {
                    notation.append(ranks.charAt(rank));
                    notation.append(suits.charAt(suit));
                    notation.append(delimiter);
                }
            }
        }
        return notation.toString();
    }

    public static long toHand(String notation) {
        if (notation.length() % 2 != 0) {
            throw new RuntimeException("Notation string must be even length!");
        }

        final var ranks = "23456789TJQKA";
        final var suits = "cdhs";

        var hand = 0L;
        while (notation.length() >= 2) {
            final var n = notation.substring(0, 2);
            notation = notation.substring(2);
            int rank = ranks.indexOf(n.charAt(0));
            int suit = suits.indexOf(n.charAt(1));

            if (rank != -1 && suit != -1) {
                hand += 0b1L << (suit * 13 + rank);
            }
        }

        return hand;
    }

    public static String typeToLongNotation(long type) {
        final var longNotation = new StringBuilder();
        if (type == Hand.HIGH_CARD) {
            longNotation.append("High card");
        } else if (type == Hand.ONE_PAIR) {
            longNotation.append("One pair");
        } else if (type == Hand.TWO_PAIR) {
            longNotation.append("Two pair");
        } else if (type == Hand.TRIPS) {
            longNotation.append("Trips");
        } else if (type == Hand.STRAIGHT) {
            longNotation.append("Straight");
        } else if (type == Hand.FLUSH) {
            longNotation.append("Flush");
        } else if (type == Hand.FULL_HOUSE) {
            longNotation.append("Full house");
        } else if (type == Hand.QUADS) {
            longNotation.append("Quads");
        } else if (type == Hand.STRAIGHT_FLUSH) {
            longNotation.append("Straight flush");
        }
        return longNotation.toString();
    }

    public static String rankToLogNotation(long rank, boolean forceSingular) {
        if (Long.bitCount(rank & TWOS) > 1 && !forceSingular) return "Twos";
        if (Long.bitCount(rank & TWOS) > 0) return "Two";
        if (Long.bitCount(rank & THREES) > 1 && !forceSingular) return "Threes";
        if (Long.bitCount(rank & THREES) > 0) return "Three";
        if (Long.bitCount(rank & FOURS) > 1 && !forceSingular) return "Fours";
        if (Long.bitCount(rank & FOURS) > 0) return "Four";
        if (Long.bitCount(rank & FIVES) > 1 && !forceSingular) return "Fives";
        if (Long.bitCount(rank & FIVES) > 0) return "Five";
        if (Long.bitCount(rank & SIXES) > 1 && !forceSingular) return "Sixes";
        if (Long.bitCount(rank & SIXES) > 0) return "Six";
        if (Long.bitCount(rank & SEVENS) > 1 && !forceSingular) return "Sevens";
        if (Long.bitCount(rank & SEVENS) > 0) return "Seven";
        if (Long.bitCount(rank & EIGHTS) > 1 && !forceSingular) return "Eights";
        if (Long.bitCount(rank & EIGHTS) > 0) return "Eight";
        if (Long.bitCount(rank & NINES) > 1 && !forceSingular) return "Nines";
        if (Long.bitCount(rank & NINES) > 0) return "Nine";
        if (Long.bitCount(rank & TENS) > 1 && !forceSingular) return "Tens";
        if (Long.bitCount(rank & TENS) > 0) return "Ten";
        if (Long.bitCount(rank & JACKS) > 1 && !forceSingular) return "Jacks";
        if (Long.bitCount(rank & JACKS) > 0) return "Jack";
        if (Long.bitCount(rank & QUEENS) > 1 && !forceSingular) return "Queens";
        if (Long.bitCount(rank & QUEENS) > 0) return "Queen";
        if (Long.bitCount(rank & KINGS) > 1 && !forceSingular) return "Kings";
        if (Long.bitCount(rank & KINGS) > 0) return "King";
        if (Long.bitCount(rank & ACES) > 1 && !forceSingular) return "Aces";
        if (Long.bitCount(rank & ACES) > 0) return "Ace";
        return "Unknown";
    }

    public static String toLongNotation(long hand) {
        final var value = Hand.valueFromHand(hand);
        final var type = Hand.typeFromValue(value);
        final var major = Hand.majorFromValue(value);
        final var minor = Hand.minorFromValue(value);
        final var kickers = Hand.kickersFromValue(value);

        final var longNotation = new StringBuilder();
        longNotation.append(typeToLongNotation(type));
        longNotation.append(", ");

        return longNotation.toString();
    }
}
