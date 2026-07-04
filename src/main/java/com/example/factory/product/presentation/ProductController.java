package com.example.factory.product.presentation;

import com.example.factory.product.application.ProductService;
import com.example.factory.product.application.dto.ProductCreateRequest;
import com.example.factory.product.application.dto.ProductDetailResponse;
import com.example.factory.product.application.dto.ProductListResponse;
import com.example.factory.product.application.dto.ProductUpdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    //상품 목록 조회
    @GetMapping
    public ResponseEntity<Page<ProductListResponse>> getAllProducts(Pageable pageable) {
        Page<ProductListResponse> responses = productService.getProducts(pageable);
        return ResponseEntity.ok(responses);
    }

    //상품 상세 정보 조회
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailResponse> getProductDetails(@PathVariable Long productId){
        ProductDetailResponse product = productService.getProductDetail(productId);
        return ResponseEntity.ok(product);
    }

    //------------------관리자-----------------

    //상품 등록
    @PostMapping
    public ResponseEntity<Void> addProduct(@Valid @RequestBody ProductCreateRequest request){
        Long productId = productService.addProduct(request);
        return ResponseEntity.created(URI.create("/api/products/"+productId)).build();
    }

    //상품 수정
    @PutMapping("/{productId}")
    public ResponseEntity<ProductDetailResponse> updateProduct(@PathVariable Long productId, @Valid @RequestBody ProductUpdateRequest request){
        ProductDetailResponse product = productService.updateProduct(productId, request);
        return ResponseEntity.ok(product);
    }

    //상품 삭제
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
