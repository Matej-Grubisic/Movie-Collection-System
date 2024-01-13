package bll;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.util.Optional;

public class MovieManager {
    public int saveNumber= 0;
    public void checkField(TextField input, String fieldLabel) {
        if (input != null) {
            if (input.getText().isEmpty()) {
                Alert AlertDialog = new Alert(Alert.AlertType.ERROR);
                AlertDialog.setTitle("Alert");
                AlertDialog.setHeaderText("You cant leave " + fieldLabel + " empty");
                Optional<ButtonType> result = AlertDialog.showAndWait();
                saveNumber =0;

            }
            if(input.getText().length()>0){
                input.getText().trim();
                saveNumber =1;

            }
        } else {
            System.out.println(fieldLabel + " input is null. Make sure it is properly initialized.");
        }
    }

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
