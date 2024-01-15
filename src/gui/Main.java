package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("MainScreen.fxml"));
        Parent root = loader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        FXMLLoader warningScreenLoader = new FXMLLoader(
                getClass().getResource("WarningScreen.fxml"));
        Parent warningScreenRoot = warningScreenLoader.load();

        // Create a new stage for the warning screen
        Stage warningStage = new Stage();
        warningStage.setScene(new Scene(warningScreenRoot));
        warningStage.show();
    }
}