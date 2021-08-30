package servlet;

import static data.ConnectionDao.getConnection;

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

@WebServlet("/ViewVendorsServlet")
public class ViewVendorsServlet extends HttpServlet {

  Connection conn = getConnection();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    List<Vendor> vendors = new ArrayList<>();
    HttpSession session = request.getSession(true);
    String firstName = (String) session.getValue("firstName");
    try {
      PreparedStatement preparedStatement = conn.prepareStatement(
          "select * from vendor");
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        Vendor vendor = new Vendor(resultSet.getLong("id"), resultSet.getString("name"),
            resultSet.getString("description"), resultSet.getString("city"),
            resultSet.getString("state"));
        vendors.add(vendor);
      }
      request.setAttribute("vendors", vendors);
      request.setAttribute("firstName", firstName);
      request.getRequestDispatcher("viewVendors.jsp").forward(request, response);
    } catch (SQLException | ServletException e) {
      e.printStackTrace();
    }
  }
}
