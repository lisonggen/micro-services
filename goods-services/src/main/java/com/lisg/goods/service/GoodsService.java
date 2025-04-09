package com.lisg.goods.service;

import com.lisg.goods.model.entity.Sku;
import com.lisg.goods.model.entity.Spu;

public interface GoodsService {

    Spu getGoodsById(String gid);

    Sku getSkuById(String sid);
}
