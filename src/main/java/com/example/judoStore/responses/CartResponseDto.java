package com.example.judoStore.responses;

import com.example.judoStore.persistence.models.Product;
import com.example.judoStore.persistence.models.ProductsCart;
import lombok.Builder;

import java.util.List;

@Builder
public record CartResponseDto(
    Long customerId,
    List<ProductsCartDto> products
) {}
