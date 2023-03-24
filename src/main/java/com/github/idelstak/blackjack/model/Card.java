package com.github.idelstak.blackjack.model;

public class Card {
    private Type type;
    private Value value;

    public Card(Type type, Value value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public int getValue() {
        return value.ordinal() < 9 ? value.ordinal() + 2 : 10;
    }
    @Override
    public String toString() {
        return value.toString().toLowerCase() + "_" + type.toString().toLowerCase();
    }
}
