package com.list.cart.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableId
    private String id;

    private String cartId;

    private String userId;

    private String spuId;

    private String skuId;

    private String skuName;

    private String spec;

    private String image;

    private Integer quantity;

    private Integer selected;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
