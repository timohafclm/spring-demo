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
        var jpql = "from Application as a where a.name = :name and a.owner = :owner";
        var count = entityManager.createQuery(jpql)
                .setParameter("name", name)
                .setParameter("owner", owner)
                .getResultList()
                .size();
        return count > 0;
    }

    @Override
    public void addApplication(Application application) {
        entityManager.persist(application);
    }

    @Override
    public Application getApplication(Long id) {
        return entityManager.find(Application.class, id);
    }

    @Override
    public void update(Application application) {
        var newApplication = getApplication(application.getId());
        newApplication.setName(application.getName());
        newApplication.setDescription(application.getDescription());
        newApplication.setOwner(application.getOwner());
        entityManager.flush();
    }

    @Override
    public void delete(Long id) {
        var application = getApplication(id);
        entityManager.remove(application);
    }
}
