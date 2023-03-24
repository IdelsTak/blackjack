package com.github.idelstak.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blackjack {

    Deck playingdeck;
    private List<Card> drawnCards;
    private List<Card> dealerCards;
    private Card card;

    public Blackjack() {
        drawnCards = new ArrayList<>();
        playingdeck = new Deck();
        dealerCards = new ArrayList<>();

    }

    public Deck getPlayingdeck() {
        return playingdeck;
    }

    public int draw(Deck deck, List<Card> hand) {
        Collections.shuffle(playingdeck.getCards());
        card = playingdeck.getCard(0);
        this.playingdeck.getCards().add(card);
        hand.add(card);
        return card.getValue();
    }

    public int getHandValue(List<Card> hand) {
        int handValue = 0;
        for (Card card : hand) {
            if (playingdeck.getCards().contains(card)) {
                handValue += card.getValue();
            }
        }
        return handValue;
    }

    public List<Card> getDrawnCards() {
        return drawnCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }
}
