package com.example.judoStore.service;

import com.example.judoStore.persistence.models.Cart;
import com.example.judoStore.responses.CartResponseDto;

public interface CartService {
    Cart updateCart(Cart cart);
    CartResponseDto getCart();
    Cart getCartById(Long id);
    void deleteCartById(Long id);
    CartResponseDto addProductToCart(Long cartId, Long productId, Long quantity);
}
