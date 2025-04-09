package com.lisg.goods.controller;

import com.lisg.goods.model.entity.Sku;
import com.lisg.goods.model.entity.Spu;
import com.lisg.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-07 10:06
 **/

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/id/{gid}")
    public Spu getGoodsById(@PathVariable String gid) {
        return goodsService.getGoodsById(gid);
    }

    @GetMapping("/sku/{id}")
    public Sku getSkuById(@PathVariable String id) {
        return goodsService.getSkuById(id);
    }
}
