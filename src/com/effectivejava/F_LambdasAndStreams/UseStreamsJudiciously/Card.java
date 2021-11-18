package com.effectivejava.F_LambdasAndStreams.UseStreamsJudiciously;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "deck=" + rank +
                ", suit=" + suit +
                '}';
    }
}
