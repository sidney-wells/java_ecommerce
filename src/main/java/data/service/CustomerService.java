package data.service;

import static data.ConnectionDao.getConnection;

import data.entity.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerService {

  Connection conn = getConnection();

  @PostConstruct
  private void init() {

  }

  public Customer createCustomer(Customer customer) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "insert into customer value (?, ?, ?, ?, ?)");
    preparedStatement.setLong(1, customer.getId());
    preparedStatement.setString(2, customer.getFirstName());
    preparedStatement.setString(3, customer.getLastName());
    preparedStatement.setString(4, customer.getEmail());
    preparedStatement.setString(5, customer.getPassword());
    preparedStatement.execute();
    return customer;
  }

  public List<Customer> getAllCustomers() throws SQLException {
    List<Customer> customers = new ArrayList<>();
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from customer");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Customer customer = new Customer(resultSet.getLong("id"), resultSet.getString("FIRST_NAME"),
          resultSet.getString("LAST_NAME"), resultSet.getString("EMAIL"),
          resultSet.getString("PASSWORD"));
      customers.add(customer);
    }
    return customers;
  }

  public Customer findCustomerById(Long id) throws SQLException {
    Customer customer = null;
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from customer where id=?");
    preparedStatement.setLong(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      customer = new Customer(resultSet.getLong("id"), resultSet.getString("FIRST_NAME"),
          resultSet.getString("LAST_NAME"), resultSet.getString("EMAIL"),
          resultSet.getString("PASSWORD"));
    }
    return customer;
  }

  public Customer updateCustomer(Customer customer) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "update customer set first_name=?, last_name=?, email=?, password=? where id=?");
    preparedStatement.setString(1, customer.getFirstName());
    preparedStatement.setString(2, customer.getLastName());
    preparedStatement.setString(3, customer.getEmail());
    preparedStatement.setString(4, customer.getPassword());
    preparedStatement.setLong(5, customer.getId());
    preparedStatement.execute();
    return customer;
  }

  public boolean deleteCustomer(Long id) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement("delete from customer where id=?");
    preparedStatement.setLong(1, id);
    preparedStatement.execute();
    return true;
  }
}
