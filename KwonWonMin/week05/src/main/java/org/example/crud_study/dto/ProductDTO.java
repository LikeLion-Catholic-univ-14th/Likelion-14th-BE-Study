package org.example.crud_study.dto;

import org.example.crud_study.entity.Product;

public class ProductDTO {
    private String productName;
    private int price;
    private Long id;

    public ProductDTO(){
    }
    public ProductDTO(Long id, String productName, int price){
        this.id = id;
        this.productName = productName;
        this.price = price;
    }


    public String getProductName(){
        return productName;
    }
    public int getPrice(){
        return price;
    }

    public Long getId(){return id;}

    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setId(Long id){this.id = id;}

    //DTO -> ENTITY로 변환
    public Product toEntity(){
        return new Product(null,productName,price);
    }


}
