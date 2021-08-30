package data.service;

import static data.ConnectionDao.getConnection;

import data.entity.Category;
import data.entity.Product;
import data.entity.Vendor;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ProductService {

  Connection conn = getConnection();

  @Inject
  VendorService vendorService;

  @Inject
  CategoryService categoryService;

  @PostConstruct
  private void init() {

  }


  public Product createProduct(Product product) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "insert into product value (?, ?, ?, ?, ?, ?)");
    preparedStatement.setLong(1, product.getId());
    preparedStatement.setString(2, product.getName());
    preparedStatement.setString(3, product.getDescription());
    preparedStatement.setLong(4, product.getPrice());
    preparedStatement.setLong(5, product.getVendor().getId());
    preparedStatement.setLong(6, product.getCategory().getId());
    preparedStatement.execute();
    return product;
  }

  public Product updateProduct(Product product) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "update product set name=?, description=?, price=?, vendor_id=?, category_id=? where id=?");
    preparedStatement.setString(1, product.getName());
    preparedStatement.setString(2, product.getDescription());
    preparedStatement.setLong(3, product.getPrice());
    preparedStatement.setObject(4, product.getVendor().getId());
    preparedStatement.setObject(5, product.getCategory().getId());
    preparedStatement.setLong(6, product.getPrice());
    preparedStatement.execute();
    return product;
  }

  public Product findProductById(Long id) throws SQLException {
    Product product = null;
    PreparedStatement preparedStatement = conn.prepareStatement("select * from product where id=?");
    preparedStatement.setLong(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Long categoryId = resultSet.getLong("category_id");
      Long vendorId = resultSet.getLong("vendor_id");
      Category category = categoryService.findCategoryById(categoryId);
      Vendor vendor = vendorService.findVendorById(vendorId);
      product = new Product(resultSet.getLong("id"), resultSet.getString("name"),
          resultSet.getString("description"), resultSet.getLong("price"),
          vendor, category);
    }
    return product;
  }

  public List<Product> getProducts() throws SQLException {
    List<Product> products = new ArrayList<>();
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from product");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Long categoryId = resultSet.getLong("category_id");
      Long vendorId = resultSet.getLong("vendor_id");
      Category category = categoryService.findCategoryById(categoryId);
      Vendor vendor = vendorService.findVendorById(vendorId);
      Product product = new Product(resultSet.getLong("id"), resultSet.getString("name"),
          resultSet.getString("description"), resultSet.getLong("price"),
          vendor, category);
      products.add(product);
    }
    return products;
  }

  public boolean deleteProduct(Long id) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement("delete from product where id=?");
    preparedStatement.setLong(1, id);
    preparedStatement.execute();
    return true;
  }
}
