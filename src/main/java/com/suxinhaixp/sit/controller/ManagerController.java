package com.suxinhaixp.sit.controller;

import com.suxinhaixp.sit.dao.ManagerDao;
import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.message.Response;
import com.suxinhaixp.sit.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @ResponseBody
    @PostMapping(value = "/IsManager")
    public Response IsManager(@RequestBody Manager manager, HttpSession session) {
        Manager manager_get=managerService.findByUsernameAndPassword(manager.getUsername(),manager.getPassword());
        if (manager_get!=null) {
            Response response=new Response("sure",manager_get);
            session.setAttribute("loginuser",manager.getUsername());
            return response;
        }
        return new Response("not",null);
    }

}
