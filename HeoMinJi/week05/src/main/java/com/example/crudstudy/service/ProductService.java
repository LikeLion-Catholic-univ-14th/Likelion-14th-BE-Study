package com.example.crudstudy.service;

import com.example.crudstudy.dto.ProductDTO;
import com.example.crudstudy.entity.Product;
import com.example.crudstudy.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> findAll(){
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }

    public Product create(ProductDTO productDTO){
        Product product = productDTO.toEntity();
        return productRepository.save(product);
    }

    public Product update(Long id, ProductDTO productDTO){
        Product product = findById(id);

        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }
}