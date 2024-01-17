package dal;

import be.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICategoryDAO {
    public String getCategory(int id) throws SQLException;

    int getCatfromName(String name) throws SQLException;

    public void deleteCategory(int id);

    public void updateCategory(Category c);

    public void createCategory(Category c);

    void deleteMovieFromCategory(int id);

    ArrayList<Category> getAllCategory();

    ArrayList<Integer> getCatMovieID(int catID);
}

