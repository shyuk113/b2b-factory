package com.example.factory.product.application;

import com.example.factory.global.exception.ProductNotFoundException;
import com.example.factory.product.domain.Product;
import com.example.factory.product.infrastructure.ProductRepository;
import com.example.factory.product.application.dto.ProductCreateRequest;
import com.example.factory.product.application.dto.ProductUpdateRequest;
import com.example.factory.product.application.dto.ProductDetailResponse;
import com.example.factory.product.application.dto.ProductListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    //상품 목록 조회
    @Transactional(readOnly = true)
    public Page<ProductListResponse> getProducts(Pageable pageable){
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductListResponse::from);
    }

    //상품 상세 정보 조회
    @Transactional(readOnly = true)
    public ProductDetailResponse getProductDetail(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product not found: " + productId));
        return ProductDetailResponse.from(product);
    }

    //상품 등록
    @Transactional
    public Long addProduct(ProductCreateRequest request){
        Product product = Product.createProduct(request.name(), request.category(), request.usageType(),
                request.widthMm(), request.lengthMm(), request.thicknessMm(),
                request.compressiveStrength(), request.color(), request.ksCertNumber(),
                request.active());

        Product savedProduct = productRepository.save(product);

        return savedProduct.getId();
    }

    //상품 수정
    @Transactional
    public ProductDetailResponse updateProduct(Long productId, ProductUpdateRequest request){
        Product product = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product not found: " + productId));
        product.updateProduct(request.name(), request.category(),
                request.usageType(), request.widthMm(),
                request.lengthMm(), request.thicknessMm(),
                request.compressiveStrength(), request.color(),
                request.ksCertNumber(), request.active());
        return ProductDetailResponse.from(product);
    }

    //상품 삭제
    @Transactional
    public void deleteProduct(Long productId){
        Product product = productRepository.findById(productId).orElseThrow(()->new ProductNotFoundException("Product not found: " + productId));
        productRepository.delete(product);
    }
}
