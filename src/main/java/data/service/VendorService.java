package data.service;

import static data.ConnectionDao.getConnection;

import data.entity.Category;
import data.entity.Vendor;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class VendorService {

  Connection conn = getConnection();

  @PostConstruct
  private void init() {

  }

  public Vendor createVendor(Vendor vendor) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "insert into vendor value (?, ?, ?, ?, ?)");
    preparedStatement.setLong(1, vendor.getId());
    preparedStatement.setString(4, vendor.getName());
    preparedStatement.setString(3, vendor.getDescription());
    preparedStatement.setString(2, vendor.getCity());
    preparedStatement.setString(5, vendor.getState());
    preparedStatement.execute();
    return vendor;
  }

  public List<Vendor> getAllVendors() throws SQLException {
    List<Vendor> vendors = new ArrayList<>();
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from vendor");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      Vendor vendor = new Vendor(resultSet.getLong("id"), resultSet.getString("name"),
          resultSet.getString("description"), resultSet.getString("city"),
          resultSet.getString("state"));
      vendors.add(vendor);
    }
    return vendors;
  }

  public Vendor findVendorById(Long id) throws SQLException {
    Vendor vendor = null;
    PreparedStatement preparedStatement = conn.prepareStatement(
        "select * from vendor where id=?");
    preparedStatement.setLong(1, id);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      vendor = new Vendor(resultSet.getLong("id"), resultSet.getString("name"),
          resultSet.getString("description"), resultSet.getString("city"),
          resultSet.getString("state"));
    }
    return vendor;
  }


  public Vendor updateVendor(Vendor vendor) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement(
        "update vendor set name=?, description=?, city=?, state=? where id=?");
    preparedStatement.setString(1, vendor.getName());
    preparedStatement.setString(2, vendor.getDescription());
    preparedStatement.setString(3, vendor.getCity());
    preparedStatement.setString(4, vendor.getState());
    preparedStatement.setLong(5, vendor.getId());
    preparedStatement.execute();
    return vendor;
  }

  public boolean deleteVendor(Long id) throws SQLException {
    PreparedStatement preparedStatement = conn.prepareStatement("delete from vendor where id=?");
    preparedStatement.setLong(1, id);
    preparedStatement.execute();
    return true;
  }
}
