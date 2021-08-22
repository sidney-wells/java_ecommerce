package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(name=Vendor.LIST_VENDORS, query="select v from Vendor v")
public class Vendor {

    public Vendor() {
    }

    public static final String LIST_VENDORS = "Vendor.listVendors";

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name="CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    // Enables bidirectional relationship b/w Vendor and Product
    @OneToMany(mappedBy = "vendor")
    private Collection<Product> products = new ArrayList<>();

    //    @OneToMany(mappedBy = "customer")
//    private Collection<Order> orders = new ArrayList<>();
//
//    @ManyToOne
//    @JoinColumn(name="CUSTOMER_ID")
//    private Customer customer;


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
