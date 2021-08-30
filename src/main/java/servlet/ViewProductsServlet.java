package servlet;

import static data.ConnectionDao.getConnection;

import data.entity.Category;
import data.entity.Product;
import data.entity.Vendor;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ViewProductsServlet")
public class ViewProductsServlet extends HttpServlet {

  Connection conn = getConnection();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Product> products = new ArrayList<>();
    HttpSession session = request.getSession(true);
    String firstName = (String) session.getValue("firstName");
    try {
      PreparedStatement preparedStatement = conn.prepareStatement(
          "select * from product");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Long categoryId = resultSet.getLong("category_id");
        Long vendorId = resultSet.getLong("vendor_id");
        PreparedStatement preparedStatement1 = conn.prepareStatement(
            "select * from category where id=?");
        preparedStatement1.setLong(1, categoryId);
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        Category category = new Category();
        while (resultSet1.next()) {
          category.setId(resultSet1.getLong("id"));
          category.setName(resultSet1.getString("name"));
          category.setDescription(resultSet1.getString("description"));
        }
        PreparedStatement preparedStatement2 = conn.prepareStatement(
            "select * from vendor where id=?");
        preparedStatement2.setLong(1, vendorId);
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        Vendor vendor = new Vendor();
        while (resultSet2.next()) {
          vendor.setId(resultSet2.getLong("id"));
          vendor.setName(resultSet2.getString("name"));
          vendor.setDescription(resultSet2.getString("description"));
          vendor.setCity(resultSet2.getString("city"));
          vendor.setState(resultSet2.getString("state"));
        }
        Product product = new Product(resultSet.getLong("id"), resultSet.getString("name"),
            resultSet.getString("description"), resultSet.getLong("price"),
            vendor, category);
        products.add(product);
      }
      request.setAttribute("products", products);
      request.setAttribute("firstName", firstName);
      request.getRequestDispatcher("viewProducts.jsp").forward(request, response);
    } catch (SQLException | ServletException e) {
      e.printStackTrace();
    }
  }
}
