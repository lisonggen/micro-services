package com.lisg.goods.controller;

import com.lisg.common.response.ResponseResult;
import com.lisg.goods.model.GoodsDTO;
import com.lisg.goods.model.entity.Sku;
import com.lisg.goods.model.entity.Spu;
import com.lisg.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseResult getGoodsById(@PathVariable String gid) {
        Spu spu = goodsService.getGoodsById(gid);
        List<Sku> skus = goodsService.getSkuBySpuId(gid);
        return ResponseResult.success(new GoodsDTO(spu, skus));
    }

    @GetMapping("/sku/{id}")
    public ResponseResult getSkuById(@PathVariable String id) {
        Sku sku = goodsService.getSkuById(id);
        return ResponseResult.success(sku);
    }

    @GetMapping("/list")
    public ResponseResult getGoodsList(@RequestParam(name = "keyword", required = false) String keyword,
                                       @RequestParam(defaultValue = "1") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize)  {
        List<Spu> goodsList = goodsService.getGoodsList(keyword, pageNo, pageSize);
        return ResponseResult.success(goodsList);
    }
}
