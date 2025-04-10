package com.lisg.goods.service.impl;

import com.lisg.goods.mapper.SpuMapper;
import com.lisg.goods.mapper.SkuMapper;
import com.lisg.goods.model.entity.Sku;
import com.lisg.goods.model.entity.Spu;
import com.lisg.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-07 10:23
 **/

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Spu getGoodsById(String gid) {
        return spuMapper.selectById(gid);
    }

    @Override
    public Sku getSkuById(String sid) {
        return skuMapper.selectById(sid);
    }

    @Override
    public List<Spu> getGoodsList(String keyword, Integer pageNo, Integer pageSize) {
        List<Spu> spus = spuMapper.selectSpuList((pageNo - 1) * pageSize, pageSize);
        return spus;
    }

}
