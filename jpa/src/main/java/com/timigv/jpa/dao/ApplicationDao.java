package com.timigv.jpa.dao;

import com.timigv.jpa.entity.Application;

public interface ApplicationDao {
    boolean applicationExist(String name, String owner);

    void addApplication(Application application);

    Application getApplication(Long id);

    void update(Application application);

    void delete(Long id);
}
