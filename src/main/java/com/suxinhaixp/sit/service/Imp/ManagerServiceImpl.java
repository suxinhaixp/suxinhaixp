package com.suxinhaixp.sit.service.Imp;

import com.suxinhaixp.sit.dao.ManagerRepository;
import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public Manager findByUsername(String username) {
        return managerRepository.findByUsername(username);
    }

    @Override
    public Manager findByPassword(String password) {
        return managerRepository.findByPassword(password);
    }

    @Override
    public Manager findByUsernameAndPassword(String username, String password) {
        return managerRepository.findByUsernameAndPassword(username,password);
    }
}
