package com.lisg.goods.model;

import com.lisg.goods.model.entity.Sku;
import com.lisg.goods.model.entity.Spu;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-15 10:31
 **/

@Data
@AllArgsConstructor
public class GoodsDTO {

    private Spu spu;

    private List<Sku> skus;
}
