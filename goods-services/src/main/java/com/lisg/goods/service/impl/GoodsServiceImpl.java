package com.lisg.goods.service.impl;

import com.lisg.goods.mapper.GoodsMapper;
import com.lisg.goods.model.entity.Spu;
import com.lisg.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-07 10:23
 **/

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Spu getGoodsById(String gid) {
        return goodsMapper.selectById(gid);
    }

}
