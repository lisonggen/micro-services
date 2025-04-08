package com.lisg.order.service;

import com.lisg.order.model.dto.OrderDTO;

public interface OrderService {

    OrderDTO getOrderById(String orderId);
}
