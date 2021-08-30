package data.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(name = Vendor.LIST_VENDORS, query = "select v from Vendor v")
@NamedQuery(name = Vendor.FIND_VENDOR_BY_ID, query = "select v from Vendor v where v.id = :id")
public class Vendor implements Serializable {

  public static final String LIST_VENDORS = "Vendor.listVendors";
  public static final String FIND_VENDOR_BY_ID = "Vendor.findById";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "NAME")
  private String name;
  @Column(name = "DESCRIPTION")
  private String description;
  @Column(name = "CITY")
  private String city;
  @Column(name = "STATE")
  private String state;

  @OneToMany
  private Collection<Product> products = new ArrayList<>();

  public Vendor() {
  }

  public Vendor(Long id, String name, String description, String city, String state) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.city = city;
    this.state = state;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Collection<Product> getProducts() {
    return products;
  }

  public void setProducts(Collection<Product> products) {
    this.products = products;
  }
}
