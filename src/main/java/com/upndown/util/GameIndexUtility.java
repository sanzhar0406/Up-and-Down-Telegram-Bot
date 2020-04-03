package com.upndown.util;

public class GameIndexUtility {

    public static int getNextPlayerIndex(int currentIndex, int playersCount){
        return  (currentIndex + 1) % playersCount;
    }

    public static int getNextNumberOfCards(int currentNumberOfCardsInRound, int roundsPlayed, int playersCount, int maxCardsCount){
        if (roundsPlayed >= maxCardsCount && roundsPlayed < maxCardsCount + playersCount){
            return currentNumberOfCardsInRound;
        }
        if (roundsPlayed > maxCardsCount && roundsPlayed >= maxCardsCount + playersCount){
            return currentNumberOfCardsInRound - 1;
        }
        return currentNumberOfCardsInRound + 1;
    }
}
