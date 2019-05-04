package com.suxinhaixp.sit.service.Imp;

import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private ManagerServiceImpl repository;

    @Override
    public Manager findByOpenid(String openid) {
        return repository.findByUsername(openid);
    }
}
