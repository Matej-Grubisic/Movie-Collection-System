package bll;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;

import java.util.Optional;

public class CategoryManager {

    public int saveNumber= 0;

    public void checkChoiceBox(ChoiceBox<String> choiceBox, String fieldLabel) {
        if (choiceBox != null) {
            if (choiceBox.getSelectionModel().isEmpty()) {
                Alert alertDialog = new Alert(Alert.AlertType.ERROR);
                alertDialog.setTitle("Alert");
                alertDialog.setHeaderText("You must choose a value for " + fieldLabel);
                Optional<ButtonType> result = alertDialog.showAndWait();
                saveNumber = 0;
            } else {
                // The choice box has a selected value
                saveNumber = 1;
            }
        } else {
            System.out.println(fieldLabel + " choiceBox is null. Make sure it is properly initialized.");
        }
    }
}
