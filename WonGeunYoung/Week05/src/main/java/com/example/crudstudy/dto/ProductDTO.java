package com.example.crudstudy.dto;

import com.example.crudstudy.entity.Product;

public class ProductDTO {
    private Long id;
    private String productName;
    private int price;

    // 기본 생성자
    public ProductDTO() {
    }

    // 생성자
    public ProductDTO(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    // Getter
    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public Long getId() { return id; }

    // Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setId(Long id) { this.id = id; }



    // DTO를 Entity로 변환
    // 사용자가 입력한 데이터를 DB에 저장할 수 있는 형태로 바꿔줌
    public Product toEntity() {
        return new Product(null, productName, price);
    }
}
