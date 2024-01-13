package dal;
import be.Movie;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO implements IMovieDAO{
    @Override
    public Movie getMovie(int id) throws SQLException {
        return null;
    }

    @Override
    public int getMovfromName(String name) throws SQLException {
        try (Connection conn = databaseConnector.getConn()) {
            String sql = "SELECT * FROM Movie WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int movieID = rs.getInt("movieID");
                int m = movieID;
                return m;
            }
        }
        return -1;
    }

    @Override
    public void deleteMovie(int id) {
        try(Connection con = databaseConnector.getConn())
        {
            String sql = "DELETE FROM Movie WHERE movieID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateMovie(Movie m)  {
        try (Connection con = databaseConnector.getConn()) {
            String sql = "UPDATE Movie SET name=?, rating=?, filelink=?, lastview=? WHERE movieID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m.getMovieTitle());
            pstmt.setInt(2, m.getImdbRating());
            pstmt.setDouble(3, m.getMovieLength());
            pstmt.setString(4, m.getFilepath());
            pstmt.setInt(5, m.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
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

