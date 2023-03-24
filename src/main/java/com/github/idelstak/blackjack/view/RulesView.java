package com.github.idelstak.blackjack.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class RulesView extends BorderPane {
    private Label text;
    private Button quitBtn;
    private Button startBtn;
    private Image image;
    private Background background;
    private BackgroundSize backgroundSize;
    private ImageView backgroundview;
    private BackgroundImage backgroundImage;

    public RulesView() {
        initialisnodes();
        layoutnodes();
    }

    private void initialisnodes() {
        text = new Label("Welcome to Blackjack! Here are the rules:\n\n" +
                "1. The goal of the game is to get as close to 21 as possible without going over.\n" +
                "2. Each player is dealt two cards to start, and then can choose to hit (take another card) or stand (keep their current hand).\n" +
                "3. Face cards (Jack, Queen, King) are worth 10 points. Aces can be worth either 1 or 11 points, depending on which is more beneficial to the player.\n" +
                "4. If a player goes over 21, they bust and lose the game.\n" +
                "5. Once all players have finished their turns, the dealer will reveal their hand and hit until they reach a total of at least 17 points.\n" +
                "6. If the dealer busts, any remaining players win. Otherwise, the player with the highest hand total without going over 21 wins.\n\n" +
                "You'll have a starter budget of €1000. Good luck!");
        startBtn = new Button("Start");
        quitBtn = new Button("Quit");
        image = new Image("com/github/idelstak/blackjack/view/table.png");
        backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, true);
        backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundSize);
        background = new Background(backgroundImage);
        backgroundview = new ImageView(image);
        backgroundview.fitWidthProperty().bind(this.widthProperty());
        backgroundview.fitHeightProperty().bind(this.heightProperty());
        this.setBackground(background);
    }

    private void layoutnodes() {
        // Add the text to a StackPane to center it
        text.setStyle("-fx-font-size: 14px");
        text.setFont(Font.font("Arial"));
        text.setTextFill(Color.WHITE);
        StackPane centerPane = new StackPane(text);
        centerPane.setPadding(new Insets(20));

        // Set the button backgrounds and add them to HBoxes
        String buttonColor = "-fx-background-color: #4B0082; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 12px; -fx-padding: 5px 10px;";
        startBtn.setStyle(buttonColor);
        quitBtn.setStyle(buttonColor);
        HBox startPane = new HBox(startBtn);
        startPane.setAlignment(Pos.BOTTOM_RIGHT);
        startPane.setPadding(new Insets(0, 20, 20, 0));

        HBox quitPane = new HBox(quitBtn);
        quitPane.setAlignment(Pos.BOTTOM_LEFT);
        quitPane.setPadding(new Insets(0, 0, 20, 20));

        // Add the start and quit panes to a BorderPane
        BorderPane bottomPane = new BorderPane();
        bottomPane.setRight(startPane);
        bottomPane.setLeft(quitPane);

        // Set the center and bottom panes
        this.setCenter(centerPane);
        this.setBottom(bottomPane);
    }



     Button getQuitBtn() {
        return quitBtn;
    }
     Button getStartBtn() {
        return startBtn;
    }
}
