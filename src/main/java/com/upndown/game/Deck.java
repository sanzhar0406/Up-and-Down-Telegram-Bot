package com.upndown.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private Stack<Card> cardsDeck;
    public static final Suit DEFAULT_SPECIAL_CARD_SUIT = Suit.DIAMOND;
    public static final Rank DEFAULT_SPECIAL_CARD_RANK = Rank.SIX;


    public Deck(Stack<Card> cardsDeck){
        this.cardsDeck = cardsDeck;
    }

    public static Deck getDeck() {
        Stack<Card> cards = new Stack<>();

        for (Rank rank : Rank.getRanks()){
            for (Suit suit : Suit.getSuits()){
                Card card = new Card(suit, rank);
                cards.push(card);
            }
        }
        return new Deck(cards);
    }


    public static Deck getDeckWithSpecialCard(Rank specialCardRank, Suit specialCardSuit){
        Stack<Card> cards = new Stack<>();

        for (Rank rank : Rank.getRanks()){
            for (Suit suit : Suit.getSuits()){
                Card card = new Card(suit, rank);
                if (specialCardRank == rank && specialCardSuit == suit){
                    card.setSpecial(true);
                }
                cards.push(card);
            }
        }
        return new Deck(cards);
    }

    public void shuffle() {
        Collections.shuffle(cardsDeck);
    }

    public List<Hand> deal(int numCards, int numPlayers) {
        List<Hand> hands = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            hands.add(Hand.createEmpty());
        }

        for (int i = 0; i < numCards; i++) {
            for (int j = 0; j < numPlayers; j++) {
                hands.get(j).getCards().add(cardsDeck.pop());
            }
        }

        return hands;
    }
}
