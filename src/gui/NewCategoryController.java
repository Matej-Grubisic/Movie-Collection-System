package gui;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class NewCategoryController {
    public ChoiceBox categorychoice;
    public Button savecatlbl;
    public Button cancelcatlbl;

    public void saveCategory(ActionEvent actionEvent) {
    }

    public void cancelCategory(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
