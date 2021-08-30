package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

  public static final String driverClassName = "com.mysql.cj.jdbc.Driver";
  public static final String URL = "jdbc:mysql://localhost:3306/ecommerce_DB";
  public static final String USER = "root";
  public static final String PASS = "password";

  public static Connection getConnection() {
    try {
      Class.forName(driverClassName);
      Connection conn = DriverManager.getConnection(URL,
          USER, PASS);
      return conn;
    } catch (SQLException | ClassNotFoundException ex) {
      throw new RuntimeException("Error connecting to DB + " + ex);
    }
  }
}
