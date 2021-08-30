package data.service;


import static data.ConnectionDao.getConnection;

import data.entity.Category;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class CategoryService {

  Connection conn = getConnection();

  public CategoryService() {
  }

  @PostConstruct
  private void init() {

  }

  public List<Category> getAllCategories() throws SQLException {
    List<Category> categories = new ArrayList<>();
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from category");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Category category = new Category(resultSet.getLong("id"), resultSet.getString("name"),
          resultSet.getString("description"));
      categories.add(category);
    }
    return categories;
  }

  public Category findCategoryById(Long id) throws SQLException {
    Category category = null;
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from Category where id=?");
    preparedStatement.setLong(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      category = new Category(resultSet.getLong("id"), resultSet.getString("name"),
          resultSet.getString("description"));
    }
    return category;
  }

  public Category createCategory(Category category) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "insert into category value (?, ?, ?)");
    preparedStatement.setLong(1, category.getId());
    preparedStatement.setString(3, category.getName());
    preparedStatement.setString(2, category.getDescription());
    preparedStatement.execute();
    return category;
  }

  public Category updateCategory(Category category) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "update category set name=?, description=? where id=?");
    preparedStatement.setString(1, category.getName());
    preparedStatement.setString(2, category.getDescription());
    preparedStatement.setLong(3, category.getId());
    preparedStatement.execute();
    return category;
  }

  public boolean deleteCategory(Long id) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement("delete from category where id=?");
    preparedStatement.setLong(1, id);
    preparedStatement.execute();
    return true;
  }
}
