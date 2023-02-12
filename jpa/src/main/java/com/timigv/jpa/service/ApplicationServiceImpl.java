package com.timigv.jpa.service;

import com.timigv.jpa.dao.ApplicationDao;
import com.timigv.jpa.entity.Application;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationDao applicationDao;

    @Override
    public synchronized boolean addApplication(Application application) {
        if (applicationDao.applicationExist(application.getName(), application.getOwner())) {
            return false;
        } else {
            applicationDao.addApplication(application);
            return true;
        }
    }
}
