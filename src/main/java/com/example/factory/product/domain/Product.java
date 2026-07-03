package com.example.factory.product.domain;

import com.example.factory.global.domain.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        indexes = @Index(name = "idx_product_category", columnList = "category"),
        uniqueConstraints = @UniqueConstraint(name = "uk_product_ks_cert_number", columnNames = "ksCertNumber")
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;

    private String usageType;

    private int widthMm;

    private int lengthMm;

    private int thicknessMm;

    private int compressiveStrength;

    private String color;

    private String ksCertNumber;

    private boolean active;

    @Builder(access = AccessLevel.PRIVATE)
    private Product(String name, String category, String usageType, int widthMm, int lengthMm, int thicknessMm
    , int compressiveStrength, String color, String ksCertNumber, boolean active) {
        this.name = name;
        this.category = category;
        this.usageType = usageType;
        this.widthMm = widthMm;
        this.lengthMm = lengthMm;
        this.thicknessMm = thicknessMm;
        this.compressiveStrength = compressiveStrength;
        this.color = color;
        this.ksCertNumber = ksCertNumber;
        this.active = active;
    }

    public static Product createProduct(String name, String category, String usageType, int widthMm, int lengthMm, int thicknessMm,
                                        int compressiveStrength, String color, String ksCertNumber, boolean active) {
        return Product.builder()
                .name(name)
                .category(category)
                .usageType(usageType)
                .widthMm(widthMm)
                .lengthMm(lengthMm)
                .thicknessMm(thicknessMm)
                .compressiveStrength(compressiveStrength)
                .color(color)
                .ksCertNumber(ksCertNumber)
                .active(active)
                .build();
    }

    public void updateProduct(String name, String category, String usageType, int widthMm, int lengthMm, int thicknessMm,
                              int  compressiveStrength, String color, String ksCertNumber, boolean active) {
        this.name = name;
        this.category = category;
        this.usageType = usageType;
        this.widthMm = widthMm;
        this.lengthMm = lengthMm;
        this.thicknessMm = thicknessMm;
        this.compressiveStrength = compressiveStrength;
        this.color = color;
        this.ksCertNumber = ksCertNumber;
        this.active = active;
    }
}
