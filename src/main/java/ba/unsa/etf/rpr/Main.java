package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"), ResourceBundle.getBundle("translation"));
        Parent root = loader.load();
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(400);
        primaryStage.setMinHeight(400);
    }


    public static void main(String[] args) {
        launch(args);

    }
}