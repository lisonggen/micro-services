package com.lisg.goods.feign;

import com.lisg.goods.dto.GoodsDTO;
import com.lisg.goods.dto.SkuDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-08 11:27
 **/

@Slf4j
@Component
public class GoodsFeignFallback implements GoodsFeign{

    @Override
    public GoodsDTO getGoodsById(String id) {
        log.info("-------------------------------调用商品服务失败");
        GoodsDTO goodsDTO = new GoodsDTO();
        goodsDTO.setId("0");
        goodsDTO.setName("默认商品");
        goodsDTO.setCaption("降级商品");
        return goodsDTO;
    }

    @Override
    public SkuDTO getSkuById(String id) {
        return null;
    }

}
