package com.example.judoStore.controller;

import com.example.judoStore.persistence.models.Cart;
import com.example.judoStore.responses.CartResponseDto;
import com.example.judoStore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public CartResponseDto getCart() {
        return cartService.getCart();
    }

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable Long id) {
        return cartService.getCartById(id);
    }

    @PostMapping("/cart")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/cart/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCartById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cart/{cartId}")
    public CartResponseDto addProductToCart(@PathVariable Long cartId, @RequestParam Long productId,
                                            @RequestParam Long quantity) {
        return cartService.addProductToCart(cartId, productId, quantity);
    }
}
