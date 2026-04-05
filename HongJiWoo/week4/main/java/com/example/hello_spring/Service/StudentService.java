package com.example.hello_spring.Service;

import com.example.hello_spring.dto.StudentJoinRequest;
import com.example.hello_spring.dto.StudentResponseDto;
import com.example.hello_spring.entity.Student;
import com.example.hello_spring.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public Long join(StudentJoinRequest request) {
        // 1. 중복 검증 로직 (Service의 역할)
        validateDuplicateStudent(request.getEmail());

        // 2. 저장 및 식별자 반환
        Student student = request.toEntity();
        return studentRepository.save(student).getId();
    }

    private void validateDuplicateStudent(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(m -> { throw new IllegalStateException("이미 존재하는 회원입니다."); });
    }

    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll().stream()
                .map(StudentResponseDto::from)
                .collect(Collectors.toList());
    }

    public StudentResponseDto findByEmail(String email) {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일을 가진 학생이 없습니다."));
        return StudentResponseDto.from(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
