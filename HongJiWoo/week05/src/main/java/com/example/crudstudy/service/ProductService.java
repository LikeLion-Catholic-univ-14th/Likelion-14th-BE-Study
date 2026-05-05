package com.example.crudstudy.service;

import com.example.crudstudy.dto.ProductDTO;
import com.example.crudstudy.entity.Product;
import com.example.crudstudy.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Read - 전체 조회
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Read - 상세 조회 (중복된 findById 하나로 병합)
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Create - 상품 생성
    public Product create(ProductDTO productDTO) {
        Product product = productDTO.toEntity();
        return productRepository.save(product);
    }

    // Update - 상품 수정
    @Transactional
    public void update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));

        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
    }

    // Delete - 상품 삭제
    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        productRepository.delete(product);
    }
}