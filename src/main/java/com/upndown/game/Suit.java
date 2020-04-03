package com.upndown.game;

public enum Suit {
    SPADE,
    HEART,
    DIAMOND,
    CLUB;

    public static Suit[] getSuits() {
        return new Suit[]{SPADE, HEART, DIAMOND, CLUB};
    }
}
