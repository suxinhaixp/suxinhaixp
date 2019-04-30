package com.suxinhaixp.sit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-06-11 17:20
 */
@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"orderId"})})
public class OrderDetail {
    @Id
    @NotNull
    private String detailId;

    /** 订单id. */
    @NotNull
    private String orderId;

    /** 商品id. */
    @NotNull
    private String productId;

    /** 商品名称. */
    @NotNull
    private String productName;

    /** 商品单价. */
    @NotNull
    private BigDecimal productPrice;

    /** 商品数量. */
    @NotNull
    private Integer productQuantity;

    /** 商品小图. */
    private String productIcon;

    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;
}
