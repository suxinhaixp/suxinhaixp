package com.suxinhaixp.sit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity(name="Manager")
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Manager {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    private String password;

   public Manager(){

   }

    public Manager(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Manager(Long id,String username, String password) {
       this.id = id;
        this.username = username;
        this.password = password;
    }

}
