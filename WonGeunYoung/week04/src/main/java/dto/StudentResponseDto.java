package dto;

import com.example.hellospring.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StudentResponseDto {
    private Long id;
    private String name;
    private String email;

    public static StudentResponseDto from(Student student) {
        return new StudentResponseDto(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }
}
