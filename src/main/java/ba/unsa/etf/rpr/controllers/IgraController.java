package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.business.MecManager;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.domain.Mec;
import ba.unsa.etf.rpr.exceptions.MojException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ResourceBundle;

public class IgraController {
    private Igrac igracX;
    private Igrac igracO;
    private IgracManager igracManager = new IgracManager();
    private MecManager mecManager = new MecManager();
    @FXML
    private Label naslov;
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



    private boolean playerXTurn = true;

    private int moves = 0;

    public IgraController(Igrac selectedIgrac1, Igrac selectedIgrac2) {
        igracX = selectedIgrac1;
        igracO = selectedIgrac2;
    }

    public void initialize() {
        naslov.setText("Igrač " + igracX.getIme() + " je na redu");
    }

    @FXML
    public void handleNazadClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/odabirIgraca.fxml"), ResourceBundle.getBundle("translation"));
            Parent root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void checkForWin() {

        if (checkRow(button1, button2, button3)) {
            showWinner(button1, button2, button3);
            return;
        }
        if (checkRow(button4, button5, button6)) {
            showWinner(button4, button5, button6);
            return;
        }
        if (checkRow(button7, button8, button9)) {
            showWinner(button7, button8, button9);
            return;
        }


        if (checkRow(button1, button4, button7)) {
            showWinner(button1, button4, button7);
            return;
        }
        if (checkRow(button2, button5, button8)) {
            showWinner(button2, button5, button8);
            return;
        }
        if (checkRow(button3, button6, button9)) {
            showWinner(button3, button6, button9);
            return;
        }


        if (checkRow(button1, button5, button9)) {
            showWinner(button1, button5, button9);
            return;
        }
        if (checkRow(button3, button5, button7)) {
            showWinner(button3, button5, button7);
            return;
        }


        if (moves == 9) {
            naslov.setText("Neriješeno!");
            disableButtons();
            igracX.uvecajNerijesene();
            igracO.uvecajNerijesene();
            Mec mec = new Mec();
            mec.setIdX(igracX.getId());
            mec.setIdO(igracO.getId());
            mec.setIdTipa(3);
            try {
                igracManager.update(igracX);
                igracManager.update(igracO);
                mecManager.add(mec);
            } catch (MojException e) {
                throw new RuntimeException(e);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kraj igre");
            alert.setHeaderText(null);
            alert.setContentText("Igra je završila neriješenim rezultatom!");
            alert.showAndWait();
            return;
        }
    }

    private boolean checkRow(Button b1, Button b2, Button b3) {
        String s1 = b1.getText();
        String s2 = b2.getText();
        String s3 = b3.getText();
        return (!s1.isEmpty() && s1.equals(s2) && s2.equals(s3));
    }

    private void showWinner(Button button1, Button button2, Button button3) {
        String winner = playerXTurn ? "X" : "O";
        button1.setStyle("-fx-background-color: red");
        button2.setStyle("-fx-background-color: red");
        button3.setStyle("-fx-background-color: red");
        disableButtons();
        String message = null;
        if(winner == "X"){
            message = igracX.getIme() + " je pobijedio!";
            igracX.uvecajPobjedu();
            igracO.uvecajPoraz();
            Mec mec = new Mec();
            mec.setIdX(igracX.getId());
            mec.setIdO(igracO.getId());
            mec.setIdTipa(1);
            try {
                igracManager.update(igracX);
                igracManager.update(igracO);
                mecManager.add(mec);
            } catch (MojException e) {
                throw new RuntimeException(e);
            }
        }
        if(winner == "O"){
            message = igracO.getIme() + " je pobijedio!";
            igracX.uvecajPoraz();
            igracO.uvecajPobjedu();
            Mec mec = new Mec();
            mec.setIdX(igracX.getId());
            mec.setIdO(igracO.getId());
            mec.setIdTipa(2);
            try {
                igracManager.update(igracX);
                igracManager.update(igracO);
                mecManager.add(mec);
            } catch (MojException e) {
                throw new RuntimeException(e);
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Kraj igre");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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
            if(playerXTurn) naslov.setText("Igrač " + igracX.getIme() + " je na redu");
            else naslov.setText("Igrač " + igracO.getIme() + " je na redu");
        }
    }

    public void handleRestartClick(ActionEvent actionEvent) {
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);

        button1.setStyle(null);
        button2.setStyle(null);
        button3.setStyle(null);
        button4.setStyle(null);
        button5.setStyle(null);
        button6.setStyle(null);
        button7.setStyle(null);
        button8.setStyle(null);
        button9.setStyle(null);

        naslov.setText("Igrač " + igracX.getIme() + " je na redu");
        moves = 0;
        playerXTurn = true;
    }
}
