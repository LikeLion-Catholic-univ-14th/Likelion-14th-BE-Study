package com.example.crud_study.dto;

import com.example.crud_study.entity.Product;

// DTO: 사용자에게 입력받은 데이터를 담는 객체
// Entity와 다르게 DB와 직접 연결되지 않음
public class ProductDTO {

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

    // Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // DTO를 Entity로 변환
    // 사용자가 입력한 데이터를 DB에 저장할 수 있는 형태로 바꿔줌
    public Product toEntity() {
        return new Product(null, productName, price);
    }
}

