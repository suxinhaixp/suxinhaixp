package com.suxinhaixp.sit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@lombok.Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

//售出
    @Id
    public Integer sellnumber;

    public String productName;



}
