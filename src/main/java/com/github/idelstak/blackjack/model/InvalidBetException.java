package com.github.idelstak.blackjack.model;

public class InvalidBetException extends Exception{
    public InvalidBetException(String message) {
        super(message);
    }
}
