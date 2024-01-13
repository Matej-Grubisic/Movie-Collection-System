package be;

public class Movie {

    private String movieTitle;
    private double movieLength;
    private int persRating;
    private int imdbRating;
    private String persRatingS;
    private String imdbRatingS;
    private String filepath;

    private String category;
    private int id;

    public Movie(String movieTitle, int imdbRating, int persRating, String filepath) {
        this.movieTitle = movieTitle;
        this.imdbRating = imdbRating;
        this.persRating = persRating;
        this.filepath = filepath;
    }

    public Movie(){

    }

    public Movie(String name, String imdb, String personal, String filelink) {
        this.movieTitle = name;
        this.imdbRatingS = imdb;
        this.persRatingS = personal;
        this.filepath = filelink;
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
    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }
    public void setPersRatingS(int persRatingS) {
        this.persRatingS = String.valueOf(persRatingS);
    }
    public void setImdbRatingS(int imdbRatingS) {
        this.imdbRatingS = String.valueOf(imdbRatingS);
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
    public int getImdbRating() {
        return imdbRating;
    }
    public String getPersRatingS() {
        return persRatingS;
    }
    public String getImdbRatingS() {
        return imdbRatingS;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public String getCategory(){
        return category;
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
