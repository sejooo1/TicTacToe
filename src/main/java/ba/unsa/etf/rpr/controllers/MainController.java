package ba.unsa.etf.rpr.controllers;

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
    private Label opcije;
    @FXML
    private Label statistika;
    @FXML
    private Label dodajIgrace;


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

    public void handleOpcijeClick(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/opcije.fxml"));
            Parent root = fxmlLoader.load();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleStatistikaClick(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/statistika.fxml"));
            Parent root = fxmlLoader.load();
            Scene newScene = new Scene(root);
            stage.setScene(newScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void handleDodajIgraceClick(MouseEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/dodajIgrace.fxml"));
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

        opcije.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleOpcijeClick(mouseEvent);
            }
        });

        statistika.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleStatistikaClick(mouseEvent);
            }
        });

        dodajIgrace.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleDodajIgraceClick(mouseEvent);
            }
        });
    }
}
