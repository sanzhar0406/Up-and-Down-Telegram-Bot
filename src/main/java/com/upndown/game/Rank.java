package com.upndown.game;

public enum Rank {
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE;

    public static Rank[] getRanks() {
        return new Rank[]{SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};
    }
}
