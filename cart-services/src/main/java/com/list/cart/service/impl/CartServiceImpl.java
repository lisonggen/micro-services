package com.list.cart.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.list.cart.mapper.CartMapper;
import com.list.cart.model.entity.CartItem;
import com.list.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private CartMapper cartMapper;

    @Override
    public void addToCart(String productId, String userId) {
//        cartMapper.insert()
    }

    @Override
    public List<CartItem> getCartItems(String userId) {
        QueryWrapper<CartItem> cartItemQueryWrapper = new QueryWrapper<>();
        cartItemQueryWrapper.eq("user_id", userId);
        return null;
    }
}
