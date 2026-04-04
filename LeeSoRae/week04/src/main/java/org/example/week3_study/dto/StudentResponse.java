package org.example.week3_study.dto;

public class StudentResponse {
    private String name;
    private String email;

    public StudentResponse(){}

    public StudentResponse(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
