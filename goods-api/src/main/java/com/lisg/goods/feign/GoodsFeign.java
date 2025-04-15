package com.lisg.goods.feign;

import com.lisg.goods.dto.SpuDTO;
import com.lisg.goods.dto.SkuDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goods-services", contextId = "cloud-goods-service", fallback = GoodsFeignFallback.class)
public interface GoodsFeign {

    @GetMapping("/api/goods/id/{id}")
    SpuDTO getGoodsById(@PathVariable("id") String id);

    @GetMapping("/api/goods/sku/{id}")
    SkuDTO getSkuById(@PathVariable("id") String id);

}
