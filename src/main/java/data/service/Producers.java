package data.service;

import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

public class Producers {

  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");

  @Produces
  @PersistenceContext(unitName = "default")
  EntityManager entityManager = entityManagerFactory.createEntityManager();
}
