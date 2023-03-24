package com.github.idelstak.blackjack.view;

import com.github.idelstak.blackjack.model.Blackjack;
import com.github.idelstak.blackjack.model.InvalidBetException;
import com.github.idelstak.blackjack.model.InvalidNameException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class InfoPresenter {
    InfoView infoView;

    public InfoPresenter(InfoView infoView) {
        this.infoView = infoView;
        addEventHandlers();
    }

    private void addEventHandlers() {
        infoView.getButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    String playerName = infoView.getName().getText();
                    if (!playerName.matches("^[a-zA-Z]*$")) {
                        throw new InvalidNameException("Invalid name");
                    }

                    int betAmount = Integer.parseInt(infoView.getBet().getText());
                    if (betAmount <= 0 || betAmount > 1000) {
                        throw new InvalidBetException("Invalid bet amount");
                    }

                    Gameview gameview = new Gameview();
                    Blackjack blackjack = new Blackjack();
                    GamePresenter gamePresenter = new GamePresenter(gameview, blackjack, infoView);
                    infoView.getScene().setRoot(gameview);
                    gameview.getScene().getWindow().sizeToScene();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid bet amount. Please enter a number.", ButtonType.OK);
                    alert.showAndWait();
                } catch (InvalidNameException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid name. Please enter only letters.", ButtonType.OK);
                    alert.showAndWait();
                } catch (InvalidBetException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid bet amount. Please enter a number between 1 and 1000.", ButtonType.OK);
                    alert.showAndWait();
                }
            }
        });
    }
}
