package entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@NamedQuery(name=Category.GET_CATEGORIES_LIST, query="select c from Category c")
@NamedQuery(name=Category.GET_CATEGORY_NAMES, query="select c.name from Category c")
@NamedQuery(name=Category.GET_PRODUCTS_BY_ID, query="select p from Category c join c.products p where c.id = :categoryId and p.id = :productId")
public class Category {

    public Category() {
    }

    public static final String GET_CATEGORIES_LIST = "Category.getAllCategories";
    public static final String GET_CATEGORY_NAMES = "Category.getCategoryNames";
    public static final String GET_PRODUCTS_BY_ID = "Category.getProductsById";

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Category name must be set")
    @Column(name="NAME")
    private String name;

    @NotEmpty(message = "Category description must be set")
    @Column(name = "DESCRIPTION")
    private String description;

    // Enables bidirectional relationship b/w Category and Product
    @OneToMany(mappedBy = "category")
    private Collection<Product> products = new ArrayList<>();

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

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
