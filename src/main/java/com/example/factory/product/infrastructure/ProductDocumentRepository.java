package com.example.factory.product.infrastructure;

import com.example.factory.product.domain.ProductDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDocumentRepository extends JpaRepository<ProductDocument, Long> {
}
