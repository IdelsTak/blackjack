package com.github.idelstak.blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private double bank;
    private double bet;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void placeBet() {
        if (bet <= bank) {
            bank -= bet;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

}

