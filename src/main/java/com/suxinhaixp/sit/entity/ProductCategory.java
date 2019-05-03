package com.suxinhaixp.sit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suxinhaixp.sit.util.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;



@DynamicUpdate
@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCategory {

    /** 类目id. */
    @Id
    @GeneratedValue
    @NotNull
    private Integer categoryId;

    /** 类目名字. */
    @NotNull
    private String categoryName;

    /** 类目编号. */
    @NotNull
    private Integer categoryType;

    @JsonSerialize(using = Date2LongSerializer.class)
    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
