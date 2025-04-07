package com.lisg.order.service.impl;

import com.lisg.order.mapper.OrderMapper;
import com.lisg.order.model.entity.Order;
import com.lisg.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-07 11:25
 **/

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.selectById(orderId);
    }

}
