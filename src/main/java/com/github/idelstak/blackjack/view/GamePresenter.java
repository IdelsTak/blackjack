package com.github.idelstak.blackjack.view;

import com.github.idelstak.blackjack.model.Blackjack;
import com.github.idelstak.blackjack.model.Card;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class GamePresenter {
    private Blackjack blackjack;
    private Gameview gameview;
    private Image cardImage;
    private ImageView cardImageView;
    private Path path;
    private InfoView infoView;
    private double bank;
    private double bet;
    private static final String STATS_FILE_PATH = "player_stats.txt";
    private String playerName;

    public GamePresenter(Gameview gameview, Blackjack blackjack, InfoView infoView) {
        this.blackjack = blackjack;
        this.gameview = gameview;
        this.infoView = infoView;
        hit();
        stand();
        blackjack.draw(blackjack.getPlayingdeck(), blackjack.getDrawnCards());
        blackjack.draw(blackjack.getPlayingdeck(), blackjack.getDrawnCards());
        blackjack.draw(blackjack.getPlayingdeck(), blackjack.getDealerCards());
        int dealervalue = blackjack.getHandValue(blackjack.getDealerCards());
        gameview.getDealerHandLbl().setText("Dealer's hand: " + dealervalue);
        showFirstCards();
        int handValue = blackjack.getHandValue(blackjack.getDrawnCards());
        gameview.getPlayerHandLbl().setText(infoView.getName().getText() + "'s hand: " + handValue);
        gameview.getBetlbl().setText("Bet:" + infoView.getBet().getText());
        bank = Integer.parseInt(gameview.getBankLbl().getText());
        bet = Integer.parseInt(infoView.getBet().getText());
        bank -= bet;
        gameview.getBankLbl().setText("Bank:€" + bank);
    }

    private void showFirstCards() {
        Card dealerCard = blackjack.getDealerCards().get(0);
        Path path1 = Paths.get("src/main/resources/cards/" + dealerCard.toString() + ".png");
        Image dealerImage = new Image(path1.toUri().toString());
        ImageView dealerCardImageView = new ImageView(dealerImage);
        dealerCardImageView.setFitWidth(60);
        dealerCardImageView.setFitHeight(90);
        HBox dealerCardsHBox = (HBox) gameview.getDealerCardPane().getChildren().get(0);
        dealerCardsHBox.getChildren().add(dealerCardImageView);

        for (int i = 0; i < 2; i++) {
            Card card = blackjack.getDrawnCards().get(i);
            path = Paths.get("src/main/resources/cards/" + card.toString() + ".png");
            cardImage = new Image(path.toUri().toString());
            ImageView playerCardImageView = new ImageView(cardImage);
            playerCardImageView.setFitWidth(60);
            playerCardImageView.setFitHeight(90);
            HBox playerCardsHBox = (HBox) gameview.getPlayerCardPane().getChildren().get(0);
            playerCardsHBox.getChildren().add(playerCardImageView);

        }
    }


    private void hit() {
        gameview.getHitBtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int handvalue = 0;
                blackjack.draw(blackjack.getPlayingdeck(), blackjack.getDrawnCards());
                handvalue += blackjack.getHandValue(blackjack.getDrawnCards());
                if (handvalue >= 21) {
                    // Disable the hit button if the player's hand value is 21 or greater
                    gameview.getHitBtn().setDisable(true);
                    stand();
                }
                gameview.getPlayerHandLbl().setText(infoView.getName().getText() + "'s hand: " + handvalue);
                path = Paths.get("src/main/resources/cards/" + blackjack.getPlayingdeck().getCards().get(0).toString() + ".png");
                cardImage = new Image(path.toUri().toString());
                ImageView newPlayerCardImageView = new ImageView(cardImage);
                newPlayerCardImageView.setFitWidth(60);
                newPlayerCardImageView.setFitHeight(90);
                HBox playerCardsHBox = (HBox) gameview.getPlayerCardPane().getChildren().get(0);
                playerCardsHBox.getChildren().add(newPlayerCardImageView);
            }

        });
    }

    private void stand() {
        gameview.getStandbtn().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int dealerhandvalue = 0;
                while (dealerhandvalue <= 17) {
                    blackjack.draw(blackjack.getPlayingdeck(), blackjack.getDealerCards());
                    dealerhandvalue = blackjack.getHandValue(blackjack.getDealerCards());
                    gameview.getDealerHandLbl().setText("Dealer's hand:" + dealerhandvalue);
                    // display card image and add it to the gameview
                    Card card = blackjack.getDealerCards().get(blackjack.getDealerCards().size() - 1);
                    path = Paths.get("src/main/resources/cards/" + card.toString() + ".png");
                    Image cardImage = new Image(path.toUri().toString());
                    ImageView newDealerCardImageView = new ImageView(cardImage);
                    newDealerCardImageView.setFitWidth(60);
                    newDealerCardImageView.setFitHeight(90);
                    HBox dealerCardsHBox = (HBox) gameview.getDealerCardPane().getChildren().get(0);
                    dealerCardsHBox.getChildren().add(newDealerCardImageView);
                }

                int playerhandvalue = blackjack.getHandValue(blackjack.getDrawnCards());
                if ((playerhandvalue > 21 && dealerhandvalue > 21) || playerhandvalue == dealerhandvalue) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You tied", ButtonType.OK);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        EndView endView = new EndView();
                        EndPresenter endPresenter = new EndPresenter(endView, blackjack);
                        gameview.getScene().setRoot(endView);
                        endView.getResultLbl().setText("Would you like to play again or quit?");
                        bank += bet;
                    }
                } else if (dealerhandvalue > 21 || (dealerhandvalue < playerhandvalue && playerhandvalue <= 21)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You won!", ButtonType.OK);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        EndView endView = new EndView();
                        EndPresenter endPresenter = new EndPresenter(endView, blackjack);
                        gameview.getScene().setRoot(endView);
                        endView.getResultLbl().setText("Would you like to play again or quit?");
                        bank = bank + bet * 1.5;
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "You lost!", ButtonType.OK);
                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.isPresent() && result.get() == ButtonType.OK) {
                        EndView endView = new EndView();
                        EndPresenter endPresenter = new EndPresenter(endView, blackjack);
                        gameview.getScene().setRoot(endView);
                        endView.getResultLbl().setText("Would you like to play again or quit?");
                    }
                }
            }
        });
    }
}

