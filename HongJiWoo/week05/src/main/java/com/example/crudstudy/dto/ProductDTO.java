package com.example.crudstudy.dto;

import com.example.crudstudy.entity.Product;

public class ProductDTO {
    private String productName;
    private int price;

    public ProductDTO() {}
    public ProductDTO(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }
    //Getter
    public String getProductName() {
        return productName;
    }
    public int getPrice() {
        return price;
    }

    //Setter
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    //DTO -> Entity로 변환
    public Product toEntity() {
        return new Product(null, productName, price);
    }
}
