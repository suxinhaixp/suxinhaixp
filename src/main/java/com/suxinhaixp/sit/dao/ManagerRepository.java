package com.suxinhaixp.sit.dao;

import com.suxinhaixp.sit.entity.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager,Long> {
    public Manager findByUsername(String username);
    public Manager findByPassword(String password);
    public Manager findByUsernameAndPassword(String username,String password);
    public Manager findByOpenid(String openid);

}
