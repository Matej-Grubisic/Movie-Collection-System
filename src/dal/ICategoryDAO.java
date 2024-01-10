package dal;

import be.Category;
import be.Movie;

import java.sql.SQLException;

public interface ICategoryDAO {

    Category getCategory(int id) throws SQLException;

    void deleteCategory(int id);

    void updateCategory(Category c);

    void createCategory(Category c);
}
