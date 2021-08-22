package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@NamedQuery(name = Product.GET_PRODUCT_LIST, query = "select p from Product p")
@NamedQuery(name = Product.FIND_PRODUCT_BY_ID, query = "select p from Product p where p.id = :id")
public class Product {

  public static final String GET_PRODUCT_LIST = "Product.findAll";
  public static final String FIND_PRODUCT_BY_ID = "Product.findById";
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotEmpty(message = "Product name must be set")
  @Column(name = "NAME")
  private String name;

  @NotEmpty(message = "Product description must be set")
  @Column(name = "DESCRIPTION")
  private String description;

  @NotEmpty(message = "Product price must be set")
  @Column(name = "PRICE")
  private Long price;

  @ManyToOne
  @JoinColumn(name = "VENDOR_ID")
  private Vendor vendor;

  @NotEmpty(message = "Product category must be set")
  @ManyToOne
  @JoinColumn(name = "CATEGORY_ID")
  private Category category;

  public Product() {
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

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Vendor getVendor() {
    return vendor;
  }

  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}
