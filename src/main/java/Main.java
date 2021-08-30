import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

  public static void main(String[] args) throws SQLException {

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_DB",
        "root", "password");

    String sql = String.format("INSERT INTO CATEGORY VALUES (?, ?, ?)");
    Statement statement = connection.createStatement();
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setInt(1, 1);
    preparedStatement.setString(2, "socks");
    preparedStatement.setString(3, "put on my feet");
    preparedStatement.execute();

    ResultSet resultSet = statement.executeQuery("select * from category");

    while (resultSet.next()) {
      System.out.println(resultSet.getString("name"));
    }
  }
}
