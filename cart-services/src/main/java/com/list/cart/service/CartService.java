package com.list.cart.service;

import com.list.cart.model.entity.CartItem;

import java.util.List;

public interface CartService {

    void addToCart(String productId);

    List<CartItem> getCartItems(String userId);

    int getCartCount();
}
