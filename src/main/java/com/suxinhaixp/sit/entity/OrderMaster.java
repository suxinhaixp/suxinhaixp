package com.suxinhaixp.sit.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.suxinhaixp.sit.enums.OrderStatusEnum;
import com.suxinhaixp.sit.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"buyerOpenid"})})
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamicUpdate
public class OrderMaster {

    /** 订单id. */
    @Id
    @NotNull
    private String orderId;

    /** 买家名字. */
    @NotNull
    private String buyerName;

    /** 买家手机号. */
    @NotNull
    private String buyerPhone;

    /** 买家地址. */
    @NotNull
    private String buyerAddress;

    /** 买家微信Openid. */
    @NotNull
    private String buyerOpenid;

    /** 订单总金额. */
    @NotNull
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    @NotNull
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认为0未支付. */
    @NotNull
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    @Column(name = "create_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createTime;

    @Column(name = "update_time",insertable = false,updatable = false,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateTime;

}
