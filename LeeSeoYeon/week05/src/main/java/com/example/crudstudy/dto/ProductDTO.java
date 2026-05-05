package com.example.crudstudy.dto;

import com.example.crudstudy.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    //Setter
    //Getter
    private String productName;
    private int price;

    public ProductDTO(){

    }

    public ProductDTO(String productName, int price){
        this.productName = productName;
        this.price = price;
    }

    //DTO -> ENTITY로 변환
    public ProductEntity toEntity(){
        return new ProductEntity(null, productName, price);
    }
}