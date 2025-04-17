package com.list.cart.controller;

import com.lisg.common.response.ResponseResult;
import com.list.cart.model.entity.CartItem;
import com.list.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-15 15:14
 **/

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add/{skuId}")
    public ResponseResult addCart(@PathVariable String skuId) {
        cartService.addToCart(skuId);
        return ResponseResult.success();
    }

    @GetMapping("/list")
    public ResponseResult listCart() {
        List<CartItem> cartItems = cartService.getCartItems("1");
        return ResponseResult.success(cartItems);
    }

    @GetMapping("/count")
    public ResponseResult countCart() {
        int count = cartService.getCartCount();
        return ResponseResult.success(count);
    }
}
