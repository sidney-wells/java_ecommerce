package repository;

import entity.Cart;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CartRepository {

    private final EntityManager entityManager;

    public CartRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Cart> findAll(Long id) {
        return entityManager.createQuery("SELECT c from Cart c").getResultList();
    }
}
