package gui;

import be.Category;
import be.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {
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
    public TableColumn title;
    public TableColumn<Movie, Double> lenght;
    public TableColumn personalRating;
    public TableColumn imdb;

    public ObservableList<Movie> movieList;
    public ObservableList<Category> categoryList;
    public TableColumn genre;
    public TableColumn numberOfFilms;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // adding movies
        title.setCellValueFactory(new PropertyValueFactory<>("movieTitle"));
        lenght.setCellValueFactory(new PropertyValueFactory<>("movieLength"));
        personalRating.setCellValueFactory(new PropertyValueFactory<>("persRating"));
        imdb.setCellValueFactory(new PropertyValueFactory<>("imdbRating"));
        movieList = FXCollections.observableArrayList();
        movieTable.setItems(movieList);

        // adding categorys
        genre.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryList = FXCollections.observableArrayList();
        categoryTable.setItems(categoryList);
    }

    public void addMovie(Movie movie){

        movieList.add(movie);
    }

    public void addGenre(Category category){
        categoryList.add(category);

    }


    public void closeApplication(ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void addCategory(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewCategory.fxml"));
        Parent root = loader.load();
        NewCategoryController newCategoryController = loader.getController();
        newCategoryController.setMainScreenController(this);
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void deleteCategory(ActionEvent actionEvent) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Confirmation");
        confirmationDialog.setHeaderText("Are you sure you want to delete this category?");
        confirmationDialog.setContentText("Any unsaved changes will be lost.");
        Optional<ButtonType> result = confirmationDialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            ObservableList<Category> allCategorys, singleCategory;
            allCategorys = categoryTable.getItems();
            singleCategory = categoryTable.getSelectionModel().getSelectedItems();
            singleCategory.forEach(allCategorys::remove);
            categoryTable.refresh();
        }
    }

    public void updateCategory(ActionEvent actionEvent) {
    }

    public void addMovie(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewMovie.fxml"));
        Parent root = loader.load();
        NewMovieController newMovieController = loader.getController();
        newMovieController.setMainScreenController(this);
        Stage primaryStage = new Stage();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void deleteMovie(ActionEvent actionEvent) {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setTitle("Confirmation");
        confirmationDialog.setHeaderText("Are you sure you want to delete this movie?");
        confirmationDialog.setContentText("Any unsaved changes will be lost.");
        Optional<ButtonType> result = confirmationDialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {

            ObservableList<Movie> allMovies, singleMovie;
            allMovies = movieTable.getItems();
            singleMovie = movieTable.getSelectionModel().getSelectedItems();
            singleMovie.forEach(allMovies::remove);
            movieTable.refresh();
        }
    }

    public void updateMovie(ActionEvent actionEvent) {
    }

    public void moveToCategory(ActionEvent actionEvent) {
    }

    public void playMovie(ActionEvent actionEvent) {
    }


}
