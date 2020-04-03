package com.upndown.game;

public class Card {

    private boolean isSpecial;
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setSpecial(boolean isSpecial) {
        this.isSpecial = isSpecial;
    }
}
