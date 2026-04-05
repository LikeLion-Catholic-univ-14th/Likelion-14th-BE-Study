package com.example.hellospring.service;

import com.example.hellospring.dto.StudentJoinRequest;
import com.example.hellospring.dto.StudentResponseDto;
import com.example.hellospring.entity.Student;
import com.example.hellospring.repository.StudentRepository;
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
        validateDuplicateStudent(request.getEmail());

        Student student = request.toEntity();
        return studentRepository.save(student).getId();
    }

    private void validateDuplicateStudent(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<StudentResponseDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(StudentResponseDto::new)
                .collect(Collectors.toList());
    }

    public StudentResponseDto getStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("학생이 존재하지 않습니다."));

        return new StudentResponseDto(student);
    }
}