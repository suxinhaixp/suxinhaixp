package com.suxinhaixp.sit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suxinhaixp.sit.enums.ProductStatusEnum;
import com.suxinhaixp.sit.util.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Data
@DynamicUpdate
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfo {

    @Id
    @NotNull
    private String productId;

    /** 名字. */
    @NotNull
    private String productName;

    /** 单价. */
    @NotNull
    private BigDecimal productPrice;

    /** 库存. */
   @NotNull
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号. */
    @NotNull
    private Integer categoryType;

    @JsonSerialize(using = Date2LongSerializer.class)
    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }
}
