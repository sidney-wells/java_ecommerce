package entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class OrderItem {

    public OrderItem() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="QUANTITY")
    private int quantity;

    @Column(name="COST")
    private Long cost;

    // OneToOne
//    @OneToOne
//    @JoinColumn(name="ORDER_ID")
//    private Order order;

    // OneToOne
    @OneToOne
    @JoinColumn(name="PRODUCT_ID")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost() {
        this.cost = quantity * product.getPrice();
    }

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
