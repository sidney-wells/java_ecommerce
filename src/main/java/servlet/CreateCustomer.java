package servlet;

import com.google.gson.Gson;
import data.entity.Customer;
import data.service.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import rest.CustomerResource;

import static data.ConnectionDao.getConnection;

import java.sql.Connection;

@WebServlet("/createCustomer")
public class CreateCustomer extends HttpServlet {

  Connection conn = getConnection();

  private Gson gson = new Gson();

  public void init() {

  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Customer customer = new Customer((long) 1, firstName, lastName, email, password);

    try {
      PreparedStatement preparedStatement = conn.prepareStatement(
          "insert into customer value (?, ?, ?, ?, ?)");
      preparedStatement.setLong(1, customer.getId());
      preparedStatement.setString(3, customer.getFirstName());
      preparedStatement.setString(4, customer.getLastName());
      preparedStatement.setString(2, customer.getEmail());
      preparedStatement.setString(5, customer.getPassword());
      preparedStatement.execute();
      request.getRequestDispatcher("login.jsp").forward(request, response);
    } catch (SQLException | ServletException e) {
      e.printStackTrace();
    }
  }
}
