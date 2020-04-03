package com.upndown.game;

import java.util.List;

public class Round {

    private int cardsCount;
    private List<Player> playerList;
    private int firstPlayerIndex;
    private Deck deck;

    public static class Builder {
        private Round newRound;

        public Builder() {
            newRound = new Round();
        }

        public Builder withCardsCount(int cardsCount){
            newRound.cardsCount = cardsCount;
            return this;
        }

        public Builder withPlayerList(List<Player> playerList){
            newRound.playerList = playerList;
            return this;
        }

        public Builder withFirstPlayerIndex(int firstPlayerIndex){
            newRound.firstPlayerIndex = firstPlayerIndex;
            return this;
        }

        public Builder withDeck(Deck deck){
            newRound.deck = deck;
            return this;
        }

        public Round build(){
            return newRound;
        }

    }

    public void play(){

    }
}
