package com.github.idelstak.blackjack.view;

import com.github.idelstak.blackjack.model.Blackjack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EndPresenter {
private EndView endView;
private Blackjack blackjack;

    public EndPresenter(EndView endView, Blackjack blackjack) {
        this.endView = endView;
        this.blackjack = blackjack;
        quit();
        playAgain();
    }

    private void quit() {
        endView.getQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
    }

    private void playAgain() {
        endView.getPlayAgain().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Gameview gameview = new Gameview();
                InfoView infoView = new InfoView();
                GamePresenter gamePresenter = new GamePresenter(gameview,blackjack,infoView);
                endView.getScene().setRoot(gameview);
                gameview.getScene().getWindow().sizeToScene();
            }
        });

    }
}
