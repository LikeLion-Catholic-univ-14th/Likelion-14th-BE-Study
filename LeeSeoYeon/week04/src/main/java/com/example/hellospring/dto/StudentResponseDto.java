package com.example.hellospring.dto;

import com.example.hellospring.entity.Student;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;

    public static StudentResponseDto of(Student student) {
        return StudentResponseDto.builder()
                .id(student.getId())
                .name(student.getName())
                .email(student.getEmail())
                .build();
    }
}