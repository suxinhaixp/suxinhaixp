package com.suxinhaixp.sit.service;

import com.suxinhaixp.sit.entity.Manager;

public interface ManagerService {

     Manager findByUsername(String username);
     Manager findByPassword(String password);
     Manager findByUsernameAndPassword(String username,String password);
}
