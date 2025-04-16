package com.list.cart.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-15 15:13
 **/

@Data
@TableName("cart_item")
public class CartItem {

    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    @TableField(value = "sku_id")
    private String skuId;

    private String spuId;

    private String skuName;

    private String spec;

    private String image;

    private Integer quantity;

    private Integer price;

    private Integer selected;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}
