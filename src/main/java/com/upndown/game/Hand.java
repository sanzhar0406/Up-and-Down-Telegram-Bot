package com.upndown.game;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    private final List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public Hand() {
        cards = new ArrayList<>();
    }

    public static Hand createEmpty() {
        return new Hand(new ArrayList<>());
    }

    public List<Card> getCards() {
        return cards;
    }
}
