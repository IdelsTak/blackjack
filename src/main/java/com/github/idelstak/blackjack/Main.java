package com.github.idelstak.blackjack;

import com.github.idelstak.blackjack.model.Blackjack;
import com.github.idelstak.blackjack.view.Gameview;
import com.github.idelstak.blackjack.view.HomePresenter;
import com.github.idelstak.blackjack.view.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        HomeView homeView = new HomeView();
        Gameview gameview = new Gameview();
        Blackjack blackjack = new Blackjack();
        HomePresenter homePresenter = new HomePresenter(homeView);
        Scene scene = new Scene(homeView, 800, 500);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
