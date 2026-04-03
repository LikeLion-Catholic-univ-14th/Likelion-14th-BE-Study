package org.example.study_3.service;

//import jakarta.transaction.Transactional;
import org.example.study_3.dto.StudentResponseDto;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.study_3.dto.StudentJoinRequest;
import org.example.study_3.entity.Student;
import org.example.study_3.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //이 클래스가 서비스 계층이다
@RequiredArgsConstructor //롬복이 생성자를 자동으로 만들어줌
@Transactional(readOnly = true) //기본 트랜잭션 설정
public class StudentService {
    //서비스가 레포지토리를 사용하기 위해 선언한 필드
    private final StudentRepository studentRepository;

    //학생 등록 처리 메서드
    @Transactional
    public Long join(StudentJoinRequest request){
        //1. 중복 검증 로직 (Service의 역할)
        validateDuplicateStudent(request.getEmail());

        //2. 저장 및 식별자 반환
        Student student = request.toEntity();
        return studentRepository.save(student).getId();
    }

    //중복 검사 메서드
    private void validateDuplicateStudent(String email){
        studentRepository.findByEmail(email)
                .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    //전체 조회
    public List<StudentResponseDto> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDto::from)
                .toList();
    }

    // 이메일로 조회
    public StudentResponseDto getStudentByEmail(String email){
        return studentRepository.findByEmail(email)
                .map(StudentResponseDto::from)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일 없음"));
    }

}
