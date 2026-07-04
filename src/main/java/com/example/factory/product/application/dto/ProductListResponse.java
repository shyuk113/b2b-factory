package com.example.factory.product.application.dto;

import com.example.factory.product.domain.Product;

public record ProductListResponse(Long id, String name, String category, String usageType, String color) {

    public static ProductListResponse from(Product product){
        return new ProductListResponse(product.getId(), product.getName(),product.getCategory(), product.getUsageType(), product.getColor());
    }
}
