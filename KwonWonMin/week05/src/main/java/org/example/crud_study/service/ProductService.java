package org.example.crud_study.service;

import org.example.crud_study.dto.ProductDTO;
import org.example.crud_study.entity.Product;
import org.example.crud_study.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    //Read - 전체 조회
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    //Read - 상세 조회
    //id에 해당하는 상품 하나를 가져옴 Entity 반환
    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    //Create - 상품 생성
    public Product create(ProductDTO productDTO){
        Product product = productDTO.toEntity();
        return productRepository.save(product);
    }

    //Update - 상품 수정
    public void update(Long id, ProductDTO dto){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(dto.getProductName());
        product.setPrice(dto.getPrice());
        productRepository.save(product);
    }

    //Delete - 상품 삭제
    public void delete(Long id){
        productRepository.deleteById(id);
    }


}
