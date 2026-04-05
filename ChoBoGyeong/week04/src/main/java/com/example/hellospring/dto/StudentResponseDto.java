package com.example.hellospring.dto;

import com.example.hellospring.entity.Student;
import lombok.Getter;

@Getter
public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;

    public StudentResponseDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
    }
}