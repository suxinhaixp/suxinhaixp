package com.suxinhaixp.sit.controller;

import com.suxinhaixp.sit.token.UserLoginToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexController {
    @UserLoginToken
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/comment")
    public String comment(){
        return "comment/comment";
    }

}
