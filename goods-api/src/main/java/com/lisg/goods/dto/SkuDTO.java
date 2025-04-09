package com.lisg.goods.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-09 16:03
 **/

@Data
public class SkuDTO {

    private String id; // 商品id

    private String sn; // 商品条码

    private String name; // SKU名称

    private Integer price; // 价格（分）

    private Integer num; // 库存数量

    private Integer alertNum; // 库存预警数量

    private String image; // 商品图片

    private String images; // 商品图片列表

    private Integer weight; // 重量（克）

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime updateTime; // 更新时间

    private String spuId; // SPUID

    private Integer categoryId; // 类目ID

    private String categoryName; // 类目名称

    private String brandName; // 品牌名称

    private String spec; // 规格

    private Integer saleNum; // 销量

    private Integer commentNum; // 评论数

    private String status; // 商品状态 1-正常，2-下架，3-删除
}
