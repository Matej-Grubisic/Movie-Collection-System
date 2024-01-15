package dal;
import be.Movie;


import java.sql.*;
import java.util.ArrayList;

public class MovieDAO implements IMovieDAO{
    @Override
    public Movie getMovie(int id) throws SQLException {
        try (Connection conn = databaseConnector.getConn()) {
            String sql = "SELECT * FROM Movie WHERE movieID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String IMDBrating = rs.getString("IMDBrating");
                String Prating = rs.getString("Prating");
                String filelink = rs.getString("filelink");
                Movie m = new Movie(name,IMDBrating,Prating,filelink);
                return m;
            }
        }
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
            String sql = "INSERT INTO Movie(name, IMDBrating,Prating,filelink, lastview) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, m.getMovieTitle());
            pstmt.setInt(2, m.getImdbRating());
            pstmt.setInt(3, m.getPersRating());
            pstmt.setString(4, m.getFilepath());
            pstmt.setString(5, "empty for now");
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Movie> getAllMovie() {
        ArrayList<Movie> movies = new ArrayList<>();

        try (Connection con = databaseConnector.getConn()) {
            String sql = "SELECT * FROM Movie";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("movieID");
                String name = rs.getString("name");
                String imdb = rs.getString("IMDBrating");
                String personal = rs.getString("Prating");
                String filelink = rs.getString("filelink");
                String lastview = rs.getString("lastview");

                Movie m = new Movie(name, imdb,personal, filelink);
                movies.add(m);
            }
            return movies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

