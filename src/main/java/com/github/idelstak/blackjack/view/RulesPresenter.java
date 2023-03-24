package com.github.idelstak.blackjack.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RulesPresenter {
    RulesView rulesView;

    public RulesPresenter(RulesView rulesView) {
        this.rulesView = rulesView;
        addEventHandlers();
    }

    private void addEventHandlers() {
        rulesView.getStartBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InfoView infoView = new InfoView();
                InfoPresenter infoPresenter = new InfoPresenter(infoView);
                rulesView.getScene().setRoot(infoView);
                infoView.getScene().getWindow().sizeToScene();
            }
        });
        rulesView.getQuitBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
    }
}
