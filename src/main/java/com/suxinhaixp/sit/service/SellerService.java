package com.suxinhaixp.sit.service;


import com.suxinhaixp.sit.entity.Manager;

public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openid
     * @return
     */
    Manager findByOpenid(String openid);
}
