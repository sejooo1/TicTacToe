package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Controller for Opcije.
 */
public class OpcijeController {
    private ResourceBundle bundle;

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

    /**
     * Handle english flag click.
     *
     * @param mouseEvent the mouse event
     */
    public void handleEnglishFlagClick(MouseEvent mouseEvent) {
        //bundle = ResourceBundle.getBundle("src/main/resources/translation_en_US.properties");
    }

    /**
     * Handle bosnian flag click.
     *
     * @param mouseEvent the mouse event
     */
    public void handleBosnianFlagClick(MouseEvent mouseEvent) {
        //bundle = ResourceBundle.getBundle("src/main/resources/translation.properties");
    }
}
