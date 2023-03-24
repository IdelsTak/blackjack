package com.github.idelstak.blackjack.view;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class InfoView extends BorderPane {
    private TextField name;
    private TextField bet;
    private Button button;
    private VBox center;
    private Label titleLabel;
    private Image image;
    private Background background;
    private BackgroundSize backgroundSize;
    private ImageView backgroundview;
    private BackgroundImage backgroundImage;
    private Label nameLbl;
    private Label betLbl;

    public InfoView(){
        initialisenodes();
        layoutnodes();
    }

    private void initialisenodes() {
        nameLbl = new Label("Name:");
        betLbl = new Label("Bet:");
        name = new TextField("");
        bet = new TextField("");
        button = new Button("Continue");
        titleLabel = new Label("Blackjack");
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
        center = new VBox(20);
        center.setAlignment(Pos.CENTER);
        this.setTop(center);

        // Style title
        titleLabel.setTextFill(Color.WHITE);
        titleLabel.setStyle("-fx-font-size: 48px;");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        center.getChildren().add(0, titleLabel);

        // Set up textfields with labels
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(20);
        center.getChildren().add(gridPane);

        // Style name label and textfield
        nameLbl.setTextFill(Color.WHITE);
        nameLbl.setMaxWidth(Double.MAX_VALUE);
        nameLbl.setAlignment(Pos.CENTER_RIGHT);
        nameLbl.setStyle("-fx-font-size: 16px;");
        GridPane.setConstraints(nameLbl, 0, 0);

        name.setMaxWidth(150);
        name.setStyle("-fx-font-size: 16px;");
        GridPane.setConstraints(name, 1, 0);

        // Style bet label and textfield
        betLbl.setTextFill(Color.WHITE);
        betLbl.setMaxWidth(Double.MAX_VALUE);
        betLbl.setAlignment(Pos.CENTER_RIGHT);
        betLbl.setStyle("-fx-font-size: 16px;");
        GridPane.setConstraints(betLbl, 0, 1);

        bet.setMaxWidth(150);
        bet.setStyle("-fx-font-size: 16px;");
        GridPane.setConstraints(bet, 1, 1);

        // Add labels and textfields to gridpane
        gridPane.getChildren().addAll(nameLbl, name, betLbl, bet);
        this.setCenter(gridPane);

        // Style button
        button.setStyle("-fx-font-size: 16px; -fx-background-color: #1E90FF; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 10px 20px;");
        HBox buttonBox = new HBox(button);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        this.setBottom(buttonBox);
    }


    public Node getStyleableNode() {
        return super.getStyleableNode();
    }

    public TextField getName() {
        return name;
    }
    public TextField getBet() {
        return bet;
    }
    public Button getButton() {
        return button;
    }
}
