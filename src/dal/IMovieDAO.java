package dal;

import be.Movie;

import java.sql.SQLException;

public interface IMovieDAO {
    public Movie getMovie(int id) throws SQLException;

    void deleteMovie(int id);

    void updateMovie(Movie m);

    void createMovie(Movie m);
}
