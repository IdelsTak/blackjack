package com.github.idelstak.blackjack.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndView extends BorderPane {
    private Label titleLabel;
    private Button playAgain;
    private Button quit;
    private VBox center;
    private Label resultLbl;
    private Image image;
    private Background background;
    private BackgroundSize backgroundSize;
    private ImageView backgroundview;
    private BackgroundImage backgroundImage;
    public EndView() {
        initialisenodes();
        layoutnodes();
    }

    private void initialisenodes() {
        titleLabel = new Label("Blackjack");
        quit = new Button("Quit");
        playAgain = new Button("Play Again");
        center = new VBox();
        resultLbl = new Label();
        image = new Image("com/github/idelstak/blackjack/view/endGame.jpg");
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
        center = new VBox(20);
        center.setAlignment(Pos.CENTER);
        this.setTop(center);

        // Style title
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setStyle("-fx-font-size: 48px;");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        center.getChildren().add(0, titleLabel);

        resultLbl.setStyle("-fx-font-size: 14px");
        resultLbl.setTextFill(Color.WHITE);
        HBox resultBox = new HBox(resultLbl);
        resultBox.setAlignment(Pos.CENTER);
        this.setBottom(resultBox);

        playAgain.setStyle("-fx-font-size: 16px; -fx-background-color: #191970; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px;");
        HBox buttonBox = new HBox(playAgain);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        this.setRight(buttonBox);

        quit.setStyle("-fx-font-size: 16px; -fx-background-color: #8B0000; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px;");
        HBox buttonBox1 = new HBox(quit);
        buttonBox1.setAlignment(Pos.BOTTOM_LEFT);
        this.setLeft(buttonBox1);

    }

    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

     Button getPlayAgain() {
        return playAgain;
    }
     Button getQuit() {
        return quit;
    }
    public Label getResultLbl() {
        return resultLbl;
    }
}