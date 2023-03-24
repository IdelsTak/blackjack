package com.github.idelstak.blackjack.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class HomeView extends BorderPane {
    Image image;
    BackgroundImage backgroundImage;
    Background background;
    BackgroundSize backgroundsize;
    ImageView backgroundview;
    Button startBtn;
    Button rulesBtn;
    Button exitBtn;

    public HomeView() {
        initialisenodes();
        layoutnodes();
    }

    private void initialisenodes() {
        image = new Image("com/github/idelstak/blackjack/view/Background.jpg");
        backgroundsize = new BackgroundSize(1.0,1.0,true,true,true,true);
        backgroundImage = new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                backgroundsize);
        background = new Background(backgroundImage);
        backgroundview = new ImageView(image);
        backgroundview.fitWidthProperty().bind(this.widthProperty());
        backgroundview.fitHeightProperty().bind(this.heightProperty());
        startBtn = new Button("Start");
        rulesBtn = new Button("Rules");
        exitBtn = new Button("Exit");
    }

    private void layoutnodes() {
        // set font
        Font arcadeFont = Font.font("System", FontWeight.BOLD, 14);
        startBtn.setFont(arcadeFont);
        rulesBtn.setFont(arcadeFont);
        exitBtn.setFont(arcadeFont);

        // set button backgrounds
        String buttonColor = "-fx-background-color: #4B0082; -fx-text-fill: white;";
        startBtn.setStyle(buttonColor);
        rulesBtn.setStyle(buttonColor);
        exitBtn.setStyle(buttonColor);

        // create VBox and set layout
        VBox vBox = new VBox(startBtn, rulesBtn, exitBtn);
        vBox.setAlignment(Pos.BOTTOM_LEFT);
        vBox.setSpacing(20);


        // add VBox to layout
        this.setBottom(vBox);
        this.setBackground(background);
    }


}
