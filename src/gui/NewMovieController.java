package gui;

import be.Movie;
import dal.MovieDAO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
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
    public TextField filelbl;
    public TextField categoryChoice;


    private MainScreenController m;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imdb.getItems().addAll(imdbrating);
        personalR.getItems().addAll(personalRating);


    }
    public void setMainScreenController(MainScreenController mainScreenController){
        this.m= mainScreenController;
    }


    public void saveMovie(ActionEvent actionEvent) {
        MovieDAO MovieDAO=new MovieDAO();
        Movie movie=new Movie();
        movie.setMovieTitle(titlelbl.getText());
        movie.setImdbRating(Integer.parseInt(imdb.getSelectionModel().getSelectedItem()));
        movie.setPersRating(Integer.parseInt(personalR.getSelectionModel().getSelectedItem()));
        movie.setMovieLength(Double.parseDouble(lengthlbl.getText()));
        movie.setCategory(categoryChoice.getText());
        m.addMovie(movie);
        MovieDAO.createMovie(movie);
        m.updateOriginalMovies();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();

    }

    public void cancelMovie(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void chooseFile(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("MP4 Files","*.mp4","*.mpeg4")
        );
        Window SongClass = null;
        fileChooser.setInitialFileName(String.valueOf(new File("C:/Films")));
        File selectedfile = fileChooser.showOpenDialog(SongClass);
        if(selectedfile != null) {
            filelbl.setText(String.valueOf(selectedfile));
        }
        else{
            System.out.println("file is not valid");

        }
    }
}
