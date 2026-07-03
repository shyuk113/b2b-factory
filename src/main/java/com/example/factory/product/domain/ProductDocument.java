package com.example.factory.product.domain;

import com.example.factory.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductDocument extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="product_id")
    private Product product;

    private String fileName;

    private String s3Key;

    @Enumerated(EnumType.STRING)
    private ProductDocumentType docType;

    @Builder(access = AccessLevel.PRIVATE)
    private ProductDocument(Product product, String fileName, String s3Key, ProductDocumentType docType) {
        this.product = product;
        this.fileName = fileName;
        this.s3Key = s3Key;
        this.docType = docType;
    }

    public static ProductDocument createDocument(Product product, String fileName, String s3Key, ProductDocumentType docType) {
        return ProductDocument.builder()
                .product(product)
                .fileName(fileName)
                .s3Key(s3Key)
                .docType(docType)
                .build();
    }

    public void updateDocument(Product product, String fileName, String s3Key, ProductDocumentType docType) {
        this.product = product;
        this.fileName = fileName;
        this.s3Key = s3Key;
        this.docType = docType;
    }

}
