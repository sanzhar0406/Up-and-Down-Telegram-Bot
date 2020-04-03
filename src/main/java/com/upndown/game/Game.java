package com.upndown.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> playerList;
    private Deck deck;
    private Suit trumpSuit = Suit.CLUB;
    private static final int MAX_PLAYERS_COUNT = 4;

    public Game(Mode mode){
        playerList = new ArrayList<>();
        if (mode == Mode.STANDARD) {
            deck = Deck.getDeck();
        }
        else{
            deck = Deck.getDeckWithSpecialCard(Deck.DEFAULT_SPECIAL_CARD_RANK, Deck.DEFAULT_SPECIAL_CARD_SUIT);
        }
    }

    public Game(Mode mode, Rank specialRank, Suit specialSuit){
        playerList = new ArrayList<>();
        if (mode == Mode.STANDARD) {
            deck = Deck.getDeck();
        }
        else{
            deck = Deck.getDeckWithSpecialCard(specialRank, specialSuit);
        }
    }

    public void setTrumpSuit(Suit trumpSuit){
        this.trumpSuit = trumpSuit;
    }

    public void addPlayer(Player player){
        if (playerList.contains(player)){
            throw new RuntimeException("Player already in the game");
        }
        if (playerList.size() == MAX_PLAYERS_COUNT){
            throw new RuntimeException("Maximum number of players is reached");
        }
        playerList.add(player);
    }

    public void removePlayer(Player player){
        if (playerList.isEmpty() || !playerList.contains(player)){
            throw new RuntimeException("Player is not in the game!");
        }
        playerList.remove(player);
    }


}
