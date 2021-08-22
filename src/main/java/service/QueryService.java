package service;

import entity.Category;
import entity.Customer;
import entity.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Stateless
public class QueryService {

  @Inject
  EntityManager entityManager;

  // Category
  public List<Category> getCategories() {
    return entityManager.createNamedQuery(Category.GET_CATEGORIES_LIST, Category.class)
        .getResultList();
  }

  public List<Product> getAllProductsByCategory(String categoryName) {
    return entityManager.createNamedQuery(Category.GET_PRODUCTS_BY_ID, Product.class)
        .setParameter("category", "%" + categoryName + "%")
        .getResultList();
  }

  // Customer
  public List<Customer> getAllCustomers() {
    return entityManager.createNamedQuery(Customer.LIST_CUSTOMERS, Customer.class)
        .getResultList();
  }


  // Product
  public List<Product> getAllProducts() {
    return entityManager.createNamedQuery(Product.GET_PRODUCT_LIST, Product.class)
        .getResultList();
  }

  public Product findProductById(Long id) {
    return entityManager.find(Product.class, id);
  }

  // Vendor


}
