package com.suxinhaixp.sit.service;


import com.suxinhaixp.sit.dto.OrderDTO;


public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
