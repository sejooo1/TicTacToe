package ba.unsa.etf.rpr;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    @FXML
    private Label novaIgra;


    @FXML
    public void handleNovaIgraClick(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/odabirIgraca.fxml"));
            Parent root = fxmlLoader.load();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        novaIgra.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleNovaIgraClick(mouseEvent);
            }
        });
    }
}
