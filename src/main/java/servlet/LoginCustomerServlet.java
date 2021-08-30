package servlet;

import static data.ConnectionDao.getConnection;

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

@WebServlet("/LoginCustomerServlet")
public class LoginCustomerServlet extends HttpServlet {

  Connection conn = getConnection();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    String email = request.getParameter("email");
    String password = request.getParameter("password");

    try {
      PreparedStatement preparedStatement = conn.prepareStatement(
          "select * from customer where email=? and password=?");
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, password);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        String firstName = resultSet.getString("first_name");
        request.setAttribute("firstName", firstName);
        HttpSession session = request.getSession(true);
        session.putValue("firstName", firstName);
        request.getRequestDispatcher("homepage.jsp").forward(request, response);
      } else {
        request.getRequestDispatcher("index.jsp").forward(request, response);
      }
    } catch (SQLException | ServletException e) {
      e.printStackTrace();
    }
  }

}
