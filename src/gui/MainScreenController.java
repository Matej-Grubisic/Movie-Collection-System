package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreenController {
    public Button closeapp;
    public TableView categoryTable;
    public TableView movieTable;
    public Button addcatbtn;
    public Button dltcatbtn;
    public Button updcatbtn;
    public Button addmoviebtn;
    public Button dltmoviebtn;
    public Button movieupd;
    public ListView movieListinCat;
    public Button movetocat;
    public Button playbtn;

    public void closeApplication(ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void addCategory(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewCategory.fxml"));
        Parent root = loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void deleteCategory(ActionEvent actionEvent) {
    }

    public void updateCategory(ActionEvent actionEvent) {
    }

    public void addMovie(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewMovie.fxml"));
        Parent root = loader.load();

        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void deleteMovie(ActionEvent actionEvent) {
    }

    public void updateMovie(ActionEvent actionEvent) {
    }

    public void moveToCategory(ActionEvent actionEvent) {
    }

    public void playMovie(ActionEvent actionEvent) {
    }
}
