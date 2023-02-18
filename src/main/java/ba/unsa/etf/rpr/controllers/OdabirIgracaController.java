package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class OdabirIgracaController {
    @FXML
    private ChoiceBox choiceBox1;
    @FXML
    private ChoiceBox choiceBox2;
    private IgracManager igracManager = new IgracManager();
    @FXML
    private Button igrajButton;

    public void initialize() {
        List<Igrac> igraci = null;
        try {
            igraci = igracManager.getAll();
            ObservableList<Igrac> items = FXCollections.observableArrayList(igraci);
            choiceBox1.setItems(items);
            choiceBox2.setItems(items);
        } catch (MojException e) {
            throw new RuntimeException(e);
        }
        igrajButton.setDisable(true);
        choiceBox1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        enableIgrajButtonIfNeeded();
    });
        choiceBox2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        enableIgrajButtonIfNeeded();
    });
}

    private void enableIgrajButtonIfNeeded() {
        Igrac selectedIgrac1 = (Igrac) choiceBox1.getSelectionModel().getSelectedItem();
        Igrac selectedIgrac2 = (Igrac) choiceBox2.getSelectionModel().getSelectedItem();
        igrajButton.setDisable(selectedIgrac1 == null || selectedIgrac2 == null || selectedIgrac1.equals(selectedIgrac2));
        igrajButton.setOnAction(event -> {
            try {
                IgraController controller = new IgraController(selectedIgrac1, selectedIgrac2);
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/igra.fxml"));
                fxmlLoader.setController(controller);
                Parent root = fxmlLoader.load();
                Scene newScene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(newScene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void handleNazadClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
