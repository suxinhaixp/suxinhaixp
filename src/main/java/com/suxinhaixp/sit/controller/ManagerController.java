package com.suxinhaixp.sit.controller;


import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.message.Response;
import com.suxinhaixp.sit.service.ManagerService;
import com.suxinhaixp.sit.service.TokenService;
import com.suxinhaixp.sit.token.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    TokenService tokenService;

    @ResponseBody
    @PostMapping(value = "/IsManager")
    public Response IsManager(@RequestBody Manager manager,HttpSession session) {
        Manager manager_get=managerService.findByUsernameAndPassword(manager.getUsername(),manager.getPassword());
        if (manager_get!=null) {
            String token = tokenService.getToken(manager_get);
            session.setAttribute("token",token);
            Response response=new Response("sure",manager_get,token);
            return response;
        }
        return new Response("not",null,null);
    }

    @UserLoginToken
    @ResponseBody
    @GetMapping("/getMessage")
    public String getMessage(){
        return "ok";
    }

}
