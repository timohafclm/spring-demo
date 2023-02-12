package com.timigv.jpa.dao;

import com.timigv.jpa.entity.Application;

public interface ApplicationDao {
    boolean applicationExist(String name, String owner);

    void addApplication(Application application);
}
