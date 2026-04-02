package com.example.hellospring.service;

import com.example.hellospring.entity.Student;
import com.example.hellospring.repository.StudentRepository;
import dto.StudentJoinRequest;
import dto.StudentResponseDto;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public Long join(StudentJoinRequest request){
        validateDuplicateStudent(request.getEmail());

        Student student = request.toEntity();
        return studentRepository.save(student).getId();
    }

    private void validateDuplicateStudent(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
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
}
