package com.lisg.order.model.dto;

import com.lisg.order.model.entity.Order;
import com.lisg.order.model.entity.OrderItem;
import lombok.Data;

import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-08 10:46
 **/

@Data
public class OrderDTO {

    private Order order;
    private List<OrderItemDTO> orderItemDTOS;
}
