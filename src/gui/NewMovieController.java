package gui;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewMovieController implements Initializable {
    public Button savebtn;
    public Button cancelNewMovie;
    public TextField titlelbl;
    public TextField lengthlbl;
    public ChoiceBox<String> imdb;
    public String[] imdbrating={"1","2","3","4","5","6","7","8","9","10"};
    public ChoiceBox<String> personalR;
    public String[] personalRating={"1","2","3","4","5","6","7","8","9","10"};
    public Button filechoosebtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imdb.getItems().addAll(imdbrating);
        personalR.getItems().addAll(personalRating);
    }


    public void saveMovie(ActionEvent actionEvent) {
    }

    public void cancelMovie(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void chooseFile(ActionEvent actionEvent) {
    }
}
