package org.example.crud_study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //상품명
    private String productName;
    //가격
    private int price;

    public Product(){

    }
    public Product(Long id, String productName, int price){
        this.id = id;
        this.productName = productName;
        this.price = price;
    }
    //Getter
    public Long getId(){
        return id;
    }
    public String getProductName(){
        return productName;
    }
    public int getPrice(){
        return price;
    }
    //Setter
    public void setId(Long id){
        this.id=id;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setPrice(int price){
        this.price = price;
    }
}
