package com.suxinhaixp.sit.service.Imp;

import com.suxinhaixp.sit.dao.ManagerDao;
import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;
    @Override
    public Manager findByUsername(String username) {
        return managerDao.findByUsername(username);
    }

    @Override
    public Manager findByPassword(String password) {
        return managerDao.findByPassword(password);
    }

    @Override
    public Manager findByUsernameAndPassword(String username, String password) {
        return managerDao.findByUsernameAndPassword(username,password);
    }
}
