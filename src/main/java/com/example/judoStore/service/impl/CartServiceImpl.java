package com.example.judoStore.service.impl;

import com.example.judoStore.persistence.models.Cart;
import com.example.judoStore.persistence.models.Product;
import com.example.judoStore.persistence.models.ProductsCart;
import com.example.judoStore.persistence.repository.CartRepository;
import com.example.judoStore.persistence.repository.ProductRepository;
import com.example.judoStore.persistence.repository.ProductsCartRepository;
import com.example.judoStore.responses.CartResponseDto;
import com.example.judoStore.responses.ProductsCartDto;
import com.example.judoStore.service.CartService;
import com.example.judoStore.service.account.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductsCartRepository productsCartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthorityService authorityService;

    @Override
    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public CartResponseDto getCart() {
        Cart cart = cartRepository.getReferenceById(authorityService.getCurrentUser().getId());
        return getProductsCartDtos(cart);

    }
    @Override
    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public CartResponseDto addProductToCart(Long cartId, Long productId, Long quantity) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        ProductsCart record = productsCartRepository.getProductsCartByCartIdAndProductId(cartId, productId);
        if (record != null) {
            record.setQuantity(record.getQuantity() + quantity);
        } else {
            record = new ProductsCart();
            record.setCart(cart);
            record.setProduct(product);
            record.setQuantity(quantity);
        }
        productsCartRepository.save(record);
        return getProductsCartDtos(cart);
    }

    private static CartResponseDto getProductsCartDtos(Cart cart) {
        List<ProductsCartDto> products = cart.getProductsCarts().stream()
                .map(productsCart ->
                        new ProductsCartDto(
                                productsCart.getCart().getId(),
                                productsCart.getProduct(),
                                productsCart.getQuantity())
                )
                .toList();
        return new CartResponseDto(
                cart.getCustomer().getId(),
                products
        );
    }
}
