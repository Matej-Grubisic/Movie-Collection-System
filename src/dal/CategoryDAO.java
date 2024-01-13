package dal;
import be.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO implements ICategoryDAO{
    @Override
    public String getCategory(int id) throws SQLException {
        try (Connection conn = databaseConnector.getConn()) {
            String sql = "SELECT * FROM Category WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name =  rs.getString("name");
                return name;
            }
        }
        return " ";
    }
    @Override
    public int getCatfromName(String name) throws SQLException {
        try (Connection conn = databaseConnector.getConn()) {
            String sql = "SELECT * FROM Category WHERE name=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int catID = rs.getInt("categoryID");
                int c = catID;
                return c;
            }
        }
        return -1;
    }

    @Override
    public void deleteCategory(int id) {
        try(Connection con = databaseConnector.getConn())
        {
            String sql = "DELETE FROM Category WHERE categoryID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCategory(Category c) {
        try (Connection con = databaseConnector.getConn()) {
            String sql = "UPDATE Category SET name=? WHERE categoryID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setInt(2, c.getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCategory(Category c) {
        try(Connection con = databaseConnector.getConn())
        {
            String sql = "INSERT INTO Category(name) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addMovieToCategory(int selectedMovieID, int selectedCategoryID) {
        try(Connection con = databaseConnector.getConn())
        {
            String sql = "INSERT INTO  CatMovie(MovieID, CategoryID) VALUES (?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, selectedMovieID);
            pstmt.setInt(2, selectedCategoryID);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

