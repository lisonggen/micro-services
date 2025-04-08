package com.lisg.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lisg.order.model.entity.OrderItem;

import java.util.List;

public interface OrderItemMapper extends BaseMapper<OrderItem> {

    List<OrderItem> selectByOrderId(String orderId);
}
