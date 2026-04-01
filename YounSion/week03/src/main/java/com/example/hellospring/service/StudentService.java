package com.example.hellospring.service;

import com.example.hellospring.dto.StudentJoinRequest;
import com.example.hellospring.entity.Student;
import com.example.hellospring.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //서비스 계층이다.
@RequiredArgsConstructor //롬복이 생성자 자동으로 만드어줌
@Transactional(readOnly = true) //기본 트랜잭션 설정
public class StudentService {

    //Service가 repository를 사용하기 위해 선언한 필드
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
    private void validateDuplicateStudent(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(m ->
                {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }
}
