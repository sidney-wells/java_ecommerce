package entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(name = Customer.LIST_CUSTOMERS, query = "select c from Customer c")
public class Customer {

    public static final String LIST_CUSTOMERS = "Customer.listCustomers";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Email(message = "Email must be in the form user@domain.com")
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    public Customer() {
    }

//    @OneToMany(mappedBy = "customer")
//    private Collection<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Collection<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(Collection<Order> orders) {
//        this.orders = orders;
//    }
}
