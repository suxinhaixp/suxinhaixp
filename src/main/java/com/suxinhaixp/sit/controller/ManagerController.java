package com.suxinhaixp.sit.controller;

import com.suxinhaixp.sit.dao.ManagerDao;
import com.suxinhaixp.sit.entity.Manager;
import com.suxinhaixp.sit.message.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class ManagerController {
    @Autowired
    private ManagerDao managerDao;

    @ResponseBody
    @PostMapping(value = "IsManager")
    public Response IsManager(Manager manager) {
        Manager manager_get=managerDao.findByUsernameAndPassword(manager.getUsername(),manager.getPassword());
        if (manager_get!=null) {
            Response response=new Response("sure",manager_get);
            return response;
        }
        return null;
    }

}
