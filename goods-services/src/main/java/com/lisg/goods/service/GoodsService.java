package com.lisg.goods.service;

import com.lisg.goods.model.entity.Sku;
import com.lisg.goods.model.entity.Spu;

import java.util.List;

public interface GoodsService {

    Spu getGoodsById(String gid);

    Sku getSkuById(String sid);

    List<Spu> getGoodsList(String keyword, Integer pageNo, Integer pageSize);
}
