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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.List;


public class StatistikaController {
    @FXML
    private Label pp,po,iz,ne;
    @FXML
    private ChoiceBox choiceBox;
    private IgracManager igracManager = new IgracManager();

    @FXML
    public void initialize() {
        try {
            List<Igrac> igraci = igracManager.getAll();
            ObservableList<Igrac> items = FXCollections.observableArrayList(igraci);
            choiceBox.setItems(items);
            choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    pp.setText(String.valueOf(((Igrac) newValue).getBrojPobjeda()));
                    po.setText(String.valueOf(((Igrac) newValue).getBrojPoraza()));
                    iz.setText(String.valueOf(((Igrac) newValue).getBrojNerijesenih()));
                    //pobjede
                }
            });
        } catch (MojException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
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
