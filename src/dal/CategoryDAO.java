package dal;
import be.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDAO implements ICategoryDAO{
    @Override
    public Category getCategory(int id) throws SQLException {
        return null;
    }

    @Override
    public void deleteCategory(int id) {

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
            String sql = "INSERT INTO Movie(name) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

