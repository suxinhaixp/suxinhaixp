package com.suxinhaixp.sit.service;

import com.suxinhaixp.sit.dto.OrderDTO;

public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
