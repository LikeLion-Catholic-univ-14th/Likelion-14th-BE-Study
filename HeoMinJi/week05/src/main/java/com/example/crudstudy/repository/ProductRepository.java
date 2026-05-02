package com.example.crudstudy.repository;

import com.example.crudstudy.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}