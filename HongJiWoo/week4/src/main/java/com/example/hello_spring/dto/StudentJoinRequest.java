package com.example.hello_spring.dto;

import com.example.hello_spring.entity.Student;

public class StudentJoinRequest {

    private String name;
    private String email;

    public StudentJoinRequest() {
    }
    public StudentJoinRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student toEntity(){
        return new Student(name, email);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
