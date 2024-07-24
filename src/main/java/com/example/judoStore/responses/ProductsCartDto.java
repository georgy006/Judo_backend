package com.example.judoStore.responses;

import com.example.judoStore.persistence.models.Product;

public record ProductsCartDto (
    Long cartId,

    Product product,

    Long quantity
) {}
