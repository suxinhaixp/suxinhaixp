package com.suxinhaixp.sit.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.suxinhaixp.sit.entity.Manager;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
@Service("TokenService")
public class TokenService {
    private  final  long EXPIRE_TIME=300 * 1000;
    public String getToken(Manager manager) {
        Date date= new Date(System.currentTimeMillis()+EXPIRE_TIME);
        String token="";
        token= JWT.create().withAudience(manager.getUsername()).withExpiresAt(date)// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(manager.getPassword()));// 以 password 作为 token 的密钥
        return token;
    }
}
