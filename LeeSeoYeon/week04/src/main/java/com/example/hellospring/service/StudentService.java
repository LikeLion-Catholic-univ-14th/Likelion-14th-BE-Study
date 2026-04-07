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

    // 기존 등록 기능
    @Transactional
    public Long join(StudentJoinRequest request) {
        validateDuplicateStudent(request.getEmail());
        Student student = request.toEntity();
        return studentRepository.save(student).getId();
    }

    private void validateDuplicateStudent(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 학생입니다.");
                });
    }

    // 전체 학생 조회
    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDto::of)
                .collect(Collectors.toList());
    }

    // 이메일로 학생 조회
    public StudentResponseDto findStudentByEmail(String email) {
        Student student = studentRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(
                        "[" + email + "] 에 해당하는 학생이 존재하지 않습니다."
                ));
        return StudentResponseDto.of(student);
    }
}