package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.business.MecManager;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.domain.Mec;
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
import java.util.*;


/**
 * Controller for Statistika.
 */
public class StatistikaController {
    @FXML
    private Label pp,po,iz,ne;
    @FXML
    private ChoiceBox choiceBox;
    private IgracManager igracManager = new IgracManager();
    private MecManager mecManager = new MecManager();

    /**
     * Initialize.
     */
    @FXML
    public void initialize() {
        try {
            List<Igrac> igraci = igracManager.getAll();
            ObservableList<Igrac> items = FXCollections.observableArrayList(igraci);
            choiceBox.setItems(items);
            choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    po.setText(String.valueOf(((Igrac) newValue).getBrojPobjeda()));
                    iz.setText(String.valueOf(((Igrac) newValue).getBrojPoraza()));
                    ne.setText(String.valueOf(((Igrac) newValue).getBrojNerijesenih()));
                    try {
                        int idPobjednika = ((Igrac)newValue).getId();
                        List<Mec> mecevi = mecManager.dajPobjedeIgraca(idPobjednika);
                        if(mecevi.size() == 0) pp.setText(String.valueOf(0));
                        else {
                            List<Integer> idGubitnika = new ArrayList<>();
                            for (Mec mec: mecevi){
                                if (mec.getIdX() == idPobjednika) idGubitnika.add(mec.getIdO());
                                if (mec.getIdO() == idPobjednika) idGubitnika.add(mec.getIdX());
                            }
                            int gubitnik = findMostFrequent(idGubitnika);
                            pp.setText(igracManager.getById(gubitnik).getIme());
                        }
                    } catch (MojException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        } catch (MojException e) {
            new Alert(Alert.AlertType.NONE, e.getMessage(), ButtonType.OK).show();
        }
    }

    /**
     * Find most frequent int.
     *
     * @param list the list
     * @return the int
     */
    public static int findMostFrequent(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i : list) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }

        int mostFrequent = list.get(0);
        for (int i : list) {
            if (frequencyMap.get(i) > frequencyMap.get(mostFrequent)) {
                mostFrequent = i;
            }
        }

        return mostFrequent;
    }

    /**
     * Handle nazad click.
     *
     * @param event the event
     */
    @FXML
    public void handleNazadClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"), ResourceBundle.getBundle("translation"));
            Parent root = (Parent) fxmlLoader.load();
            Scene newScene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
