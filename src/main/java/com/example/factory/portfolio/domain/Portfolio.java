package com.example.factory.portfolio.domain;

import com.example.factory.global.domain.BaseEntity;
import com.example.factory.product.domain.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    private String clientType;

    private String location;

    private int quantity;

    private int year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private String imageS3Key;

    @Builder(access = AccessLevel.PRIVATE)
    private Portfolio(String clientName, String clientType, String location, int quantity, int year, Product product, String imageS3Key) {
        this.clientName = clientName;
        this.clientType = clientType;
        this.location = location;
        this.quantity = quantity;
        this.year = year;
        this.product = product;
        this.imageS3Key = imageS3Key;
    }

    public static Portfolio createPortfolio(String clientName, String clientType, String location, int quantity, int year, Product product, String imageS3Key) {
        return Portfolio.builder()
                .clientName(clientName)
                .clientType(clientType)
                .location(location)
                .quantity(quantity)
                .year(year)
                .product(product)
                .imageS3Key(imageS3Key)
                .build();

    }

    public void updatePortfolio(String clientName, String clientType, String location, int quantity, int year, Product product, String imageS3Key) {
        this.clientName = clientName;
        this.clientType = clientType;
        this.location = location;
        this.quantity = quantity;
        this.year = year;
        this.product = product;
        this.imageS3Key = imageS3Key;
    }
}
