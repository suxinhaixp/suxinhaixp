package com.suxinhaixp.sit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suxinhaixp.sit.util.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Date;

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
    @JsonSerialize(using = Date2LongSerializer.class)
    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;
    @JsonSerialize(using = Date2LongSerializer.class)
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;
}
