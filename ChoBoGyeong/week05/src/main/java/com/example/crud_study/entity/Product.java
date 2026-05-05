package com.example.crud_study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity: 이 클래스가 DB 테이블과 연결된다는 뜻
@Entity
public class Product {

    // @Id: 기본키(PK)
    @Id
    // @GeneratedValue: id 값을 자동으로 증가시켜줌
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 상품명
    private String productName;

    // 가격
    private int price;

    // 기본 생성자
    // JPA가 객체를 만들 때 필요함
    public Product() {
    }

    // 값을 넣어서 객체를 만들 때 사용하는 생성자
    public Product(Long id, String productName, int price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    // Getter
    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    // Setter
    public void setId(Long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

