package com.list.cart.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lisg.goods.dto.SkuDTO;
import com.lisg.goods.feign.GoodsFeign;
import com.list.cart.mapper.CartItemMapper;
import com.list.cart.model.entity.CartItem;
import com.list.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-15 15:19
 **/

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartItemMapper cartItemMapper;

    @Autowired
    private GoodsFeign goodsFeign;

    @Override
    public void addToCart(String skuId, String userId) {
        SkuDTO skuDTO = goodsFeign.getSkuById(skuId).getData();
        CartItem cartItem = new CartItem();
        BeanUtil.copyProperties(skuDTO, cartItem);
        cartItem.setUserId(userId);
        cartItem.setSkuId(skuId);
        cartItem.setSkuName(skuDTO.getName());
        cartItem.setQuantity(1);
        cartItem.setSelected(1);
        cartItem.setCreateTime(LocalDateTime.now());
        cartItem.setUpdateTime(LocalDateTime.now());
        cartItemMapper.insert(cartItem);
    }

    @Override
    public List<CartItem> getCartItems(String userId) {
        QueryWrapper<CartItem> cartItemQueryWrapper = new QueryWrapper<>();
        cartItemQueryWrapper.eq("user_id", userId);
        return cartItemMapper.selectList(cartItemQueryWrapper);
    }
}
