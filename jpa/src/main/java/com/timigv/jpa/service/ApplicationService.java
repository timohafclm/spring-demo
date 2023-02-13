package com.timigv.jpa.service;

import com.timigv.jpa.entity.Application;

public interface ApplicationService {

    boolean addApplication(Application application);

    Application getApplication(Long id);

    void update(Application application);

    void delete(Long id);
}
