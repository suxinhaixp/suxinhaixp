package com.suxinhaixp.sit.controller;

import com.suxinhaixp.sit.dao.DataRepository;
import com.suxinhaixp.sit.entity.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class DataController {

    @Autowired
    DataRepository dataRepository;

    @GetMapping("/selectsell")
    public List<Data> selectsel(@RequestParam("create_time") String create_time){

        return dataRepository.getselled(create_time);
    }
}
