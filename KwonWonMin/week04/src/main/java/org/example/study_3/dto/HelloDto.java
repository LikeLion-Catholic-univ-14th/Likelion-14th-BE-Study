package org.example.study_3.dto;

public class HelloDto {
    private String message;
    private String name;

    public HelloDto(){

    }
    public HelloDto(String message, String name){
        this.message = message;
        this.name = name;
    }
    public String getMessage(){
        return message;
    }

    public String getName(){
        return name;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void setName(String name){
        this.name = name;
    }
}
