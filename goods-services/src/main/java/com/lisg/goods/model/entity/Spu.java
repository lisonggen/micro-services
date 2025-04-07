package com.lisg.goods.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-07 10:13
 **/

@Data
@TableName("tb_spu")
public class Spu implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)  // 主键自增
    private String id;                // 主键
    private String sn;                // 货号
    private String name;              // SPU名
    private String caption;           // 副标题
    private Integer brandId;          // 品牌ID
    private Integer category1Id;      // 一级分类
    private Integer category2Id;      // 二级分类
    private Integer category3Id;      // 三级分类
    private Integer templateId;       // 模板ID
    private Integer freightId;        // 运费模板id
    private String image;             // 图片
    private String images;            // 图片列表
    private String saleService;       // 售后服务
    private String introduction;      // 介绍
    private String specItems;         // 规格列表
    private String paraItems;         // 参数列表
    private Integer saleNum = 0;      // 销量
    private Integer commentNum = 0;   // 评论数
    private String isMarketable = "0";    // 是否上架
    private String isEnableSpec = "1";    // 是否启用规格
    private String isDelete = "0";        // 是否删除
    private String status = "0";          // 审核状态
}
