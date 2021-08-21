package entity;

import jakarta.persistence.*;

@Entity
//@NamedQueries({
//        @NamedQuery(name = "Cart.findAll", query = "")
//})
public class Cart {

    public Cart() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
