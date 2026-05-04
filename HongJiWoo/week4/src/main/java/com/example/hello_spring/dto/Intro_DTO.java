package com.example.hello_spring.dto;

public class Intro_DTO {
    private String name;
    private String major;

    public Intro_DTO(String name, String major) {
        this.name = name;
        this.major = major;
    }
    public String getName() {
        return name;
    }
    public String getMajor() {
        return major;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMajor(String major) {
        this.major = major;
    }
}
