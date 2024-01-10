package gui;

import be.Category;
import dal.CategoryDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCategoryController implements Initializable {
    public String[] categoryName={"Comedy","Horror","Drama","Action","Crime","Romance","Thriller","Documentary","Science fiction"};
    public ChoiceBox categorychoice;
    public Button savecatlbl;
    public Button cancelcatlbl;
    private Category categoryToUpdate;

    private MainScreenController m;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        categorychoice.getItems().addAll(categoryName);
    }
    public void setMainScreenController(MainScreenController mainScreenController){
        this.m=mainScreenController;
    }

    public void saveCategory(ActionEvent actionEvent) {
        Category category=new Category();
        CategoryDAO categoryDAO= new CategoryDAO();
        if(categoryToUpdate!=null){
            categoryToUpdate.setName((String) categorychoice.getSelectionModel().getSelectedItem());
            categoryDAO.updateCategory(categoryToUpdate);
            m.updateCategoryInList(categoryToUpdate);
        }
        else {
            category.setName((String) categorychoice.getSelectionModel().getSelectedItem());
            m.addGenre(category);
            categoryDAO.createCategory(category);
        }
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void cancelCategory(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    public void setCategoryToUpdate(Category category) {
        this.categoryToUpdate=category;
        categorychoice.setValue(category.getName());
    }
}
