package com.example.crud_study.service;

import com.example.crud_study.dto.ProductDTO;
import com.example.crud_study.entity.Product;
import com.example.crud_study.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product findById(long id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
    }

    public Product create(ProductDTO productDTO){
        Product product=productDTO.toEntity();
        return productRepository.save(product);
    }
    public Product update(long id, ProductDTO productDTO){
        Product product=findById(id);
        product.setProductName(productDTO.getProductName());
        product.setPrice(productDTO.getPrice());
        return productRepository.save(product);
    }
    public void delete(long id){
        productRepository.deleteById(id);
    }
}
