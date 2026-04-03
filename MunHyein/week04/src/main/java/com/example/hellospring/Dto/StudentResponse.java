package com.example.hellospring.Dto;

import com.example.hellospring.entitiy.Student;
import lombok.Getter;

@Getter
public class StudentResponse {
    private Long id;
    private String name;
    private String email;

    public StudentResponse(Long id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
    }
    public static StudentResponse from(Student student){
        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }

}
