package com.example.hellospring.dto;

public class IntroDto {
    private String name;
    private String major;

    public IntroDto(String name, String major){
        this.name = name;
        this.major = major;
    }

    public String getName(){
        return name;
    }

    public String getMajor(){
        return major;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setMajor(String major){
        this.major = major;
        }
}

