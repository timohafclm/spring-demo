package com.timigv.jpa.dao;

import com.timigv.jpa.entity.Application;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ApplicationDaoImpl implements ApplicationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean applicationExist(String name, String owner) {
        var jpql = "FROM Application AS a WHERE a.name = ? AND a.owner = ?";
        var count = entityManager.createQuery(jpql).setParameter(0, name).setParameter(1, owner)
                .getResultList()
                .size();
        return count > 0;
    }

    @Override
    public void addApplication(Application application) {
        entityManager.persist(application);
    }
}
