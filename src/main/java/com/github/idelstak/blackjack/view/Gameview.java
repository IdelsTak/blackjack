package com.github.idelstak.blackjack.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.nio.file.Path;

public class Gameview extends BorderPane {
    private Label BankLbl;
    private Label Betlbl;
    private Button HitBtn;
    private Button Standbtn;
    private BackgroundImage backgroundImage;
    private Image image;
    private Background background;
    private BackgroundSize backgroundSize;
    private ImageView backgroundview;
    private Label playerHandLbl;
    private Label dealerHandLbl;
    private ImageView playercardsView;
    private ImageView dealerCardsview;
    private StackPane playerCardPane;
    private StackPane dealerCardPane;

    public Gameview() {
        initialisenodes();
        layoutNodes();
    }

    private void initialisenodes() {
        BankLbl = new Label("1000");
        playerHandLbl = new Label();
        dealerHandLbl = new Label();
        Betlbl = new Label("Bet: ");
        HitBtn = new Button("Hit");
        Standbtn = new Button("Stand");
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
        playercardsView = new ImageView();
        dealerCardsview = new ImageView();
        playerCardPane = new StackPane();
        dealerCardPane = new StackPane();
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

    private void layoutNodes() {
        // Dealer's cards
        dealerHandLbl.setStyle("-fx-text-fill: white; -fx-font-size: 16");
        HBox dealerCardsHBox = new HBox();
        dealerCardsHBox.setAlignment(Pos.CENTER);
        dealerCardsHBox.setSpacing(5);
        dealerCardPane.getChildren().add(dealerCardsHBox);
        VBox dealerBox = new VBox(dealerHandLbl, dealerCardPane);
        dealerBox.setAlignment(Pos.TOP_CENTER);
        dealerBox.setSpacing(10);
        dealerBox.setPadding(new Insets(10));
        this.setTop(dealerBox);

        // Player's cards
        playerHandLbl.setStyle("-fx-text-fill: white; -fx-font-size: 16");
        HBox playerCardsHBox = new HBox();
        playerCardsHBox.setAlignment(Pos.CENTER);
        playerCardsHBox.setSpacing(5);
        playerCardPane.getChildren().add(playerCardsHBox);
        VBox playerBox = new VBox(playerCardPane, playerHandLbl);
        playerBox.setAlignment(Pos.BOTTOM_CENTER);
        playerBox.setSpacing(10);
        playerBox.setPadding(new Insets(10));
        this.setCenter(playerBox);



        // Player's info (bet and bank)
        Betlbl.setStyle("-fx-text-fill: white; -fx-font-size: 13");
        BankLbl.setStyle("-fx-text-fill: white; -fx-font-size: 13");
        VBox playerInfoBox = new VBox(Betlbl, BankLbl);
        playerInfoBox.setSpacing(10);
        playerInfoBox.setPadding(new Insets(10));
        this.setRight(playerInfoBox);

        // Hit and stand buttons
        HBox hBox = new HBox(HitBtn, Standbtn);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.setSpacing(10);
        //hBox.setPadding(new Insets(10));
        this.setBottom(hBox);

        // Styling
        HitBtn.setStyle("-fx-background-color: #2E8B57; -fx-text-fill: white; -fx-font-size: 14; -fx-font-weight: bold; -fx-padding: 10 20;");
        Standbtn.setStyle("-fx-background-color: #DC143C; -fx-text-fill: white; -fx-font-size: 14; -fx-font-weight: bold; -fx-padding: 10 20;");
    }

    Label getPlayerHandLbl() {
        return playerHandLbl;
    }
    Label getDealerHandLbl() {
        return dealerHandLbl;
    }
    Label getBetlbl() {
        return Betlbl;
    }
    Label getBankLbl() {
        return BankLbl;
    }
    Button getHitBtn() {
        return HitBtn;
    }
    Button getStandbtn() {
        return Standbtn;
    }
    ImageView getPlayercardsView() {
        return playercardsView;
    }
    ImageView getDealerCardsview() {
        return dealerCardsview;
    }
    StackPane getPlayerCardPane() {
        return playerCardPane;
    }
    StackPane getDealerCardPane() {
        return dealerCardPane;
    }
}