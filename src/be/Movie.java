package be;

import javafx.collections.ObservableList;

public class Movie {

    private String movieTitle;
    private double movieLength;
    private int persRating;
    private String imdbRating;
    private String filepath;
    private int id;

    public Movie(String movieTitle, Double movieLength, String imdbRating, int persRating, String filepath) {
        this.movieTitle = movieTitle;
        this.movieLength = movieLength;
        this.imdbRating = imdbRating;
        this.persRating = persRating;
        this.filepath = filepath;

    }

    public Movie(){

    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public void setMovieLength(double movieLength) {
        this.movieLength = movieLength;
    }
    public void setPersRating(int persRating) {
        this.persRating = persRating;
    }
    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }
    public double getMovieLength() {
        return movieLength;
    }
    public int getPersRating() {
        return persRating;
    }
    public String getImdbRating() {
        return imdbRating;
    }

    public String getFilepath() {
        return filepath;
    }

    public int getId() {
        return id;
    }
    public String getMovieLengthString() {

        long minutes = (long) ((movieLength % 3600) / 60);
        long seconds = (long) (movieLength % 60);

        return String.format("%02d:%02d", minutes, seconds);
    }
}
