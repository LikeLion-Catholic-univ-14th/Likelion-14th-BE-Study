package org.example.study_3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.study_3.entity.Student;

@Getter
@AllArgsConstructor
public class StudentResponseDto {
    private Long id;
    private String name;
    private String email;

    public static StudentResponseDto from(Student student){
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }
}
