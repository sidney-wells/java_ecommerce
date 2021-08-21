import entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        // Create objects
        Product product = new Product();
        Category category = new Category();
        Vendor vendor = new Vendor();
        Customer customer = new Customer();
        OrderItem orderItem = new OrderItem();
        Cart cart = new Cart();

        // Collections to use
        Collection<Product> products = new ArrayList<>();
//        Collection<Order> orders = new ArrayList<>();

        // Set properties customer
        customer.setFirstName("Sidney");
        customer.setLastName("Wells");
        customer.setPassword("password");
        customer.setEmail("sidneywells101@gmail.com");

        // Set properties order
//        order.setCustomer(customer);

        // Set properties vendor
        vendor.setCity("Neptune");
        vendor.setState("New Jersey");
        vendor.setName("Sid's Warehouse");
        vendor.setDescription("All the avocados");

        // Set properties category
        category.setName("Clothes");
        category.setDescription("attire you wear");

        // Set properties product
        product.setName("Shoes");
        product.setDescription("sports shoes");
        product.setPrice((long) 19.99);
        product.setCategory(category);
        product.setVendor(vendor);
        products.add(product);

        // Add collections
        category.setProducts(products);
//        customer.setOrders(orders);
        vendor.setProducts(products);

        // Set properties of OrderItem
        orderItem.setQuantity(5);
        orderItem.setProduct(product);

        // Pass to DB
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.persist(vendor);
        entityManager.persist(category);
        entityManager.persist(product);
        entityManager.persist(cart);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
