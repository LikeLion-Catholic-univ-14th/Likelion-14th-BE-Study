package com.example.crudstudy.service;

import com.example.crudstudy.dto.ProductDTO;
import com.example.crudstudy.entity.Product;
import com.example.crudstudy.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // 생성자 주입: ProductRepository를 사용할 수 있게 연결
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
                .orElseThrow(() -> new RuntimeException("상품을 찾을 수 없습니다. ID: " + id));
    }

    // Create - 상품 생성
    // DTO를 Entity로 바꾼 뒤 DB에 저장
    @Transactional
    public Product create(ProductDTO productDTO) {
        Product product = productDTO.toEntity();
        return productRepository.save(product);
    }

    @Transactional
    public void update(ProductDTO productDTO) {
        Product product = productRepository.findById(productDTO.getId())
                .orElseThrow(() -> new RuntimeException("수정할 상품을 찾을 수 없습니다. ID: " + productDTO.getId()));
        product.update(productDTO.getProductName(), productDTO.getPrice());

    }

    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("삭제할 상품이 존재하지 않습니다. ID: " + id);
        }

        // 2. 데이터 삭제
        productRepository.deleteById(id);
    }
}