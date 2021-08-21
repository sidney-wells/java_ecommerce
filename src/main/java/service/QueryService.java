package service;

import entity.Category;
import entity.Product;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@Stateless
public class QueryService {

    @Inject
    EntityManager entityManager;

    public List<Category> getCategories() {
        return null;
    }

    public List<Product> getProducts() {
        return null;
    }


}
