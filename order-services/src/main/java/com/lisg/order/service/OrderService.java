package com.lisg.order.service;

import com.lisg.order.model.entity.Order;

public interface OrderService {

    Order getOrderById(String orderId);
}
