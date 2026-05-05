package com.example.crud_study.repository;

import com.example.crud_study.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository: DB와 직접 연결되는 역할
// JpaRepository<Product, Long>
// Product: 관리할 Entity
// Long: Product의 id 타입
public interface ProductRepository extends JpaRepository<Product, Long> {
}

