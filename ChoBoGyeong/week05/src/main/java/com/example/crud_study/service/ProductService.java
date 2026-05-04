package com.example.crud_study.service;

import com.example.crud_study.dto.ProductDTO;
import com.example.crud_study.entity.Product;
import com.example.crud_study.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service: 이 클래스가 Service 계층임을 Spring에게 알려줌
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // 생성자 주입
    // ProductRepository를 사용할 수 있게 연결
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Read - 전체 조회
    // DB에 저장된 모든 상품을 가져옴
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Read - 상세 조회
    // id에 해당하는 상품 하나를 가져옴
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    // Create - 상품 생성
    // DTO를 Entity로 바꾼 뒤 DB에 저장
    public Product create(ProductDTO productDTO) {
        Product product = productDTO.toEntity();
        return productRepository.save(product);
    }

    // 수정
    public Product update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());

        return productRepository.save(product);
    }

    // 삭제
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}

