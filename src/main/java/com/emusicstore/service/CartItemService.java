package com.emusicstore.service;

import com.emusicstore.model.Cart;
import com.emusicstore.model.CartItem;

public interface CartItemService {
public void addCartItem(CartItem cartItem);

void removeCartItem(CartItem cartItem);


void removeAllCartItems(Cart cart);


CartItem getCartItemByProductId(int productId);
}
