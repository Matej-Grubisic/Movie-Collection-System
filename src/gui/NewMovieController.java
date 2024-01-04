package gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewMovieController {
    public Button savebtn;
    public Button cancelNewMovie;
    public TextField titlelbl;
    public TextField lengthlbl;
    public ChoiceBox imdb;
    public ChoiceBox personalR;

    public void saveMovie(ActionEvent actionEvent) {
    }

    public void cancelMovie(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
