package com.example.crudstudy.service;

import com.example.crudstudy.dto.ProductDTO;
import com.example.crudstudy.entity.ProductEntity;
import com.example.crudstudy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }

    public ProductEntity findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }

    public ProductEntity create(ProductDTO productDTO){
        ProductEntity product = productDTO.toEntity();
        return productRepository.save(product);
    }

    public ProductEntity update(Long id, ProductDTO productDTO) {
        ProductEntity product = findById(id);
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}