package com.example.crudstudy.repository;

import com.example.crudstudy.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Override
    List<Product> findAll(); // 반환 타입을 Iterable에서 List로 재정의
}
