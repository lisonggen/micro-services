package com.lisg.order.model.dto;

import com.lisg.goods.dto.SpuDTO;
import lombok.Data;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-08 10:49
 **/

@Data
public class OrderItemDTO {

    private String id;

    private Integer categoryId1;
    private Integer categoryId2;
    private Integer categoryId3;

    private String spuId;
    private String skuId;
    private String orderId;

    private String name;
    private Integer price;
    private Integer num;
    private Integer money;
    private Integer payMoney;

    private String image;
    private Integer weight;
    private Integer postFee;
    private String isReturn;

    private SpuDTO goods;
}
