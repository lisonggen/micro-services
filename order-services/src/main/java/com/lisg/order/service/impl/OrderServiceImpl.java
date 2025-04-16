package com.lisg.order.service.impl;

import com.lisg.goods.dto.SpuDTO;
import com.lisg.goods.feign.GoodsFeign;
import com.lisg.order.mapper.OrderItemMapper;
import com.lisg.order.mapper.OrderMapper;
import com.lisg.order.model.dto.OrderDTO;
import com.lisg.order.model.dto.OrderItemDTO;
import com.lisg.order.model.entity.Order;
import com.lisg.order.model.entity.OrderItem;
import com.lisg.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private GoodsFeign goodsFeign;

    @Override
    public OrderDTO getOrderById(String orderId) {
        Order order = orderMapper.selectById(orderId);
        List<OrderItemDTO> orderItemDTOS = new ArrayList<>();
        List<OrderItem> orderItems = orderItemMapper.selectByOrderId(orderId);
        orderItems.forEach(orderItem -> {
            OrderItemDTO orderItemDTO = new OrderItemDTO();
            SpuDTO goodsDTO = goodsFeign.getGoodsById(orderItem.getSpuId()).getData();
            BeanUtils.copyProperties(orderItem, orderItemDTO);
            orderItemDTO.setGoods(goodsDTO);
            orderItemDTOS.add(orderItemDTO);
        });

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrder(order);
        orderDTO.setOrderItemDTOS(orderItemDTOS);
        return orderDTO;
    }

}
