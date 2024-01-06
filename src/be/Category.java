package be;

import java.util.ArrayList;

public class Category {
    private String name;
    private ArrayList<Movie> allMovies;
    private int id;

    public Category(String name, ArrayList<Movie> allMovies) {
        this.name = name;
        this.allMovies = allMovies;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Movie> getAllMovies() {
        return allMovies;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAllMovies(ArrayList<Movie> allMovies) {
        this.allMovies = allMovies;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void removeMovies(Movie movie){
        allMovies.remove(movie);
    }
    public void getMovieCount(){
        allMovies.size();
    }
}
