package dal;

import be.Category;
import be.Movie;

import java.sql.SQLException;

public interface ICategoryDAO {
    public Category getCategory(int id) throws SQLException;
    public void deleteCategory(int id);
    public void updateCategory(Category c);
    public void createCategory(Category c);
}
