package com.example.hello_spring.dto;

public class HelloDto {
    private String message;
    private String name;

    public HelloDto(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public HelloDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public String getName() {
        return name;
    }
}
