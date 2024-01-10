package dal;


import be.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MovieDAO implements IMovieDAO {
    @Override
    public Movie getMovie(int id) throws SQLException {
        return null;
    }

    @Override
    public void deleteMovie(int id) {

    }

    @Override
    public void updateMovie(Movie m) {

    }

    @Override
    public void createMovie(Movie m) {
        try(Connection con = databaseConnector.getConn())
        {
            String sql = "INSERT INTO Movie(name, rating,filelink, lastview) VALUES (?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m.getMovieTitle());
            pstmt.setInt(2, m.getImdbRating());
            pstmt.setDouble(3, m.getMovieLength());
            pstmt.setString(4, "empty for now");
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
