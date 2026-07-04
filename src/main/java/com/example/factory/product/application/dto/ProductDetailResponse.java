package com.example.factory.product.application.dto;

import com.example.factory.product.domain.Product;

public record ProductDetailResponse(
        Long productId,

        String name,

        String category,

        String usageType,

        int widthMm,

        int lengthMm,

        int thicknessMm,

        int compressiveStrength,

        String color,

        String ksCertNumber,

        boolean active) {

    public static ProductDetailResponse from(Product product){
        return new ProductDetailResponse(product.getId(), product.getName(), product.getCategory(), product.getUsageType(), product.getWidthMm(),
                product.getLengthMm(), product.getThicknessMm(), product.getCompressiveStrength(), product.getColor(),
                product.getKsCertNumber(), product.isActive());
    }
}
