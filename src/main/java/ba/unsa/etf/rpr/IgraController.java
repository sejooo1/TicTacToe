package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class IgraController {
    @FXML
    public void handleNazadClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/odabirIgraca.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Label naslov;

    private boolean playerXTurn = true;

    private int moves = 0;

    private void checkForWin() {
        // Horizontal Wins
        if (checkRow(button1, button2, button3)) {
            showWinner(button1);
            return;
        }
        if (checkRow(button4, button5, button6)) {
            showWinner(button4);
            return;
        }
        if (checkRow(button7, button8, button9)) {
            showWinner(button7);
            return;
        }

        // Vertical Wins
        if (checkRow(button1, button4, button7)) {
            showWinner(button1);
            return;
        }
        if (checkRow(button2, button5, button8)) {
            showWinner(button2);
            return;
        }
        if (checkRow(button3, button6, button9)) {
            showWinner(button3);
            return;
        }

        // Diagonal Wins
        if (checkRow(button1, button5, button9)) {
            showWinner(button1);
            return;
        }
        if (checkRow(button3, button5, button7)) {
            showWinner(button3);
            return;
        }

        // Check for tie game
        if (moves == 9) {
            naslov.setText("Tie Game!");
        }
    }

    private boolean checkRow(Button b1, Button b2, Button b3) {
        String s1 = b1.getText();
        String s2 = b2.getText();
        String s3 = b3.getText();
        return (!s1.isEmpty() && s1.equals(s2) && s2.equals(s3));
    }

    private void showWinner(Button button) {
        String winner = playerXTurn ? "X" : "O";
        String message = winner == null ? "The game ended in a tie!" : winner + " has won the game!";
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        disableButtons();
    }

    private void disableButtons() {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }

    @FXML
    public void buttonClicked(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        if (button.getText().isEmpty()) {
            String mark = playerXTurn ? "X" : "O";
            button.setText(mark);
            moves++;
            checkForWin();
            playerXTurn = !playerXTurn;
            naslov.setText("Player " + (playerXTurn ? "X" : "O") + "'s turn");
        }
    }
}
