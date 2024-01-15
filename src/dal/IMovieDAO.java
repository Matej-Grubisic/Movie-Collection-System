package dal;

import be.Movie;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IMovieDAO {
    public Movie getMovie(int id) throws SQLException;

    public int getMovfromName(String name) throws SQLException;

    public void deleteMovie(int id);
    public void updateMovie(Movie m) ;
    public void createMovie(Movie m);

    List<Movie> getAllMovie();
}
