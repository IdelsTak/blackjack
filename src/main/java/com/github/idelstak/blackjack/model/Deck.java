package com.github.idelstak.blackjack.model;

import java.util.ArrayList;

import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        createFullDeck();
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }
    public void removeCard(Card card) {
        cards.remove(card);
    }
    public void createFullDeck() {
        for (Type type : Type.values()) {
            for (Value value : Value.values()) {
                cards.add(new Card(type, value));
            }
        }
    }
    public List<Card> getCards() {
        return cards;
    }
}
