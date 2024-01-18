package dal;
import be.Category;

import java.sql.*;
import java.util.ArrayList;

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

            //delete movie form category
            String sql2 = "DELETE FROM CatMovie WHERE CatMovieID=?";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, id);
            pstmt2.execute();
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

    @Override
    public void deleteMovieFromCategory(int id) {
        try(Connection con = databaseConnector.getConn())
        {
            String sql2 = "DELETE FROM CatMovie WHERE CategoryID=?";
            PreparedStatement pstmt2 = con.prepareStatement(sql2);
            pstmt2.setInt(1, id);
            pstmt2.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Category> getAllCategory(){
        ArrayList<Category> categories = new ArrayList<>();

        try (Connection con = databaseConnector.getConn()) {
            String sql = "SELECT * FROM Category";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("categoryID");
                String name = rs.getString("name");
                Category c = new Category(name);
                categories.add(c);
            }
            return categories;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Integer> getCatMovieID(int catID){
        ArrayList<Integer> movieIDs = new ArrayList<>();
        try (Connection con = databaseConnector.getConn()) {
            String sql = "SELECT * FROM CatMovie WHERE CategoryID=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, catID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int movID = rs.getInt("MovieID");
                movieIDs.add(movID);
            }
            return movieIDs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getMovieIDFromCatMovieID(int catMovieId, int MovieID) throws SQLException {
        try (Connection conn = databaseConnector.getConn()) {
            String sql = "SELECT MovieID FROM CatMovie WHERE CategoryID=? AND MovieID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, catMovieId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("MovieID");
            }

        }
        return -1;
    }

}

