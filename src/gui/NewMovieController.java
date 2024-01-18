package gui;

import be.Movie;
import bll.MovieManager;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class NewMovieController implements Initializable {
    public Button savebtn;
    public Button cancelNewMovie;
    public TextField titlelbl;

    public ChoiceBox<String> imdb;
    public String[] imdbrating={"1","2","3","4","5","6","7","8","9","10"};
    public ChoiceBox<String> personalR;
    public String[] personalRating={"1","2","3","4","5","6","7","8","9","10"};
    public Button filechoosebtn;
    public TextField filelbl;
    public TextField categoryChoice;
    private Movie movieToUpdate;


    private MainScreenController m;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imdb.getItems().addAll(imdbrating);
        personalR.getItems().addAll(personalRating);


    }
    public void setMainScreenController(MainScreenController mainScreenController){
        this.m= mainScreenController;
    }

    //If the save button is clicked after user have updated some parameters of the movie it replaces the old mpovies with new.
    //If user was filling the fields for the first time it creates a new movie and adds it to the list.
    public void saveMovie(ActionEvent actionEvent) throws SQLException {
        MovieDAO movieDAO = new MovieDAO();
        if (movieToUpdate != null) {
           update();
        } else {
            create();
        }

        Stage stage = (Stage) savebtn.getScene().getWindow();
        stage.close();
    }

        public void update() throws SQLException {
            MovieManager movieManager = new MovieManager();
            movieManager.checkField(titlelbl, "Title");
            movieManager.checkChoiceBox(imdb, "imdb Rating");
            movieManager.checkChoiceBox(personalR, "Personal Rating");
            movieManager.checkField(filelbl, "Filepath");
            if (movieManager.saveNumber == 1) {
                MovieDAO movieDAO = new MovieDAO();
                int movieID = movieDAO.getMovfromName(movieToUpdate.getMovieTitle());
                movieToUpdate.setId(movieID);
                movieToUpdate.setMovieTitle(titlelbl.getText());
                movieToUpdate.setImdbRatingS(Integer.parseInt(imdb.getValue()));
                movieToUpdate.setPersRatingS(Integer.parseInt(personalR.getValue()));
                movieToUpdate.setFilepath(filelbl.getText());

                movieDAO.updateMovie(movieToUpdate);
                m.updateMovieInList(movieToUpdate);
            }
        }

        public void create() {
            MovieManager movieManager = new MovieManager();
            movieManager.checkField(titlelbl, "Title");
            movieManager.checkChoiceBox(imdb,"imdb Rating");
            movieManager.checkChoiceBox(personalR,"Personal Rating");
            movieManager.checkField(filelbl,"Filepath");

            if (movieManager.saveNumber == 1) {
                MovieDAO movieDAO = new MovieDAO();
                Movie movie = new Movie();
                movie.setMovieTitle(titlelbl.getText());
                movie.setImdbRatingS(Integer.parseInt(imdb.getValue()));
                movie.setPersRatingS(Integer.parseInt(personalR.getValue()));

                movie.setFilepath(filelbl.getText());
                movieDAO.createMovie(movie);
                m.addMovie(movie);
                m.updateOriginalMovies();
            }
        }

    //Closes add or update movie window.
    public void cancelMovie(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    //This method extracts all filled fields of movie so that user
    // can see what parameters are at the moment and what he wants to change
    public void setMovieToUpdate(Movie movie) {
        this.movieToUpdate = movie;

        titlelbl.setText(movie.getMovieTitle());
        imdb.setValue(String.valueOf(movie.getImdbRating()));
        personalR.setValue(String.valueOf(movie.getPersRating()));

        filelbl.setText(movie.getFilepath());

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