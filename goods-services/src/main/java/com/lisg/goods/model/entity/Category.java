package com.lisg.goods.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 15:53
 **/

@Data
@TableName("tb_category")
public class Category {

    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    private String name;
    private Integer parentId;
}
