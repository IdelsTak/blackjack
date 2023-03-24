package com.github.idelstak.blackjack.view;

import com.github.idelstak.blackjack.model.Blackjack;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class HomePresenter {
    HomeView homeView;

    public HomePresenter(HomeView homeView) {
        this.homeView = homeView;
        addEventHandlers();
    }

    private void addEventHandlers() {
        homeView.startBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InfoView infoView = new InfoView();
                InfoPresenter infoPresenter = new InfoPresenter(infoView);
                homeView.getScene().setRoot(infoView);
                infoView.getScene().getWindow().sizeToScene();
            }
        });
        homeView.exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });
        homeView.rulesBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RulesView rulesView = new RulesView();
                RulesPresenter rulesPresenter = new RulesPresenter(rulesView);
                homeView.getScene().setRoot(rulesView);
                rulesView.getScene().getWindow().sizeToScene();
            }
        });
    }
}
