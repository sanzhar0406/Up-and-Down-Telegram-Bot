package com.upndown.game;

import com.upndown.util.GameIndexUtility;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> playerList;
    private Suit trumpSuit = Suit.CLUB;
    private static final int MAX_PLAYERS_COUNT = 4;
    private static final int MAX_CARDS_COUNT = 7;
    private GameStatus gameStatus;
    private Mode mode;
    private Suit specialSuit = Deck.DEFAULT_SPECIAL_CARD_SUIT;
    private Rank specialRank = Deck.DEFAULT_SPECIAL_CARD_RANK;
    private int firstPlayerIndex = -1;
    private int currentNumberOfCardsInRound = 0;
    private int roundsPlayed = 0;

    public Game(Mode mode){
        playerList = new ArrayList<>();
        this.mode = mode;
        gameStatus = GameStatus.CREATED;
    }

    public Game(Mode mode, Rank specialRank, Suit specialSuit){
        playerList = new ArrayList<>();
        this.mode = mode;
        this.specialRank = specialRank;
        this.specialSuit = specialSuit;
        gameStatus = GameStatus.CREATED;
    }

    public void setTrumpSuit(Suit trumpSuit){
        this.trumpSuit = trumpSuit;
    }

    public void addPlayer(Player player){
        if (gameStatus == GameStatus.STARTED || gameStatus == GameStatus.STOPPED){
            throw new RuntimeException("Player cannot be added");
        }
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

    public void startGame(){
        gameStatus = GameStatus.STARTED;
        playNextRound();


    }

    private void playNextRound() {
        this.firstPlayerIndex = GameIndexUtility.getNextPlayerIndex(this.firstPlayerIndex, playerList.size());
        this.currentNumberOfCardsInRound = GameIndexUtility.getNextNumberOfCards(currentNumberOfCardsInRound,
                roundsPlayed, playerList.size(), MAX_CARDS_COUNT);
        Deck deck;
        if (mode == Mode.STANDARD) {
            deck = Deck.getDeck();
        } else {
            deck = Deck.getDeckWithSpecialCard(specialRank, specialSuit);
        }
        deck.shuffle();
        Round round = new Round.Builder()
                .withCardsCount(currentNumberOfCardsInRound)
                .withPlayerList(playerList)
                .withDeck(deck)
                .withFirstPlayerIndex(firstPlayerIndex)
                .build();
        round.play();
    }

    public void stop(){
        gameStatus = GameStatus.STOPPED;
    }

}
