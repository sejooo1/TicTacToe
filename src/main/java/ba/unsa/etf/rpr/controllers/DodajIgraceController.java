package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.IgracManager;
import ba.unsa.etf.rpr.domain.Igrac;
import ba.unsa.etf.rpr.exceptions.MojException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DodajIgraceController {
    @FXML
    private TextField unesiIme;
    private IgracManager igracManager = new IgracManager();

    @FXML
    public void handleDodajClick(ActionEvent event) {
        try {
            String imeIgraca = unesiIme.getText().trim();
            if (imeIgraca.isEmpty()) {
                new Alert(Alert.AlertType.WARNING, "Morate unijeti ime igrača.", ButtonType.OK).show();
            } else {
                Igrac igrac = new Igrac();
                igrac.setIme(imeIgraca);
                igrac.setBrojPobjeda(0);
                igrac.setBrojNerijesenih(0);
                igrac.setBrojPoraza(0);
                igracManager.add(igrac);
                new Alert(Alert.AlertType.INFORMATION, "Uspješno dodan novi igrač.", ButtonType.OK).show();
                unesiIme.clear();
            }
        } catch (MojException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK).show();
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
