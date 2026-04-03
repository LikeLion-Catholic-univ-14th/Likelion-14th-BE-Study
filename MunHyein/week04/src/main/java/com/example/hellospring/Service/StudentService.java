package com.example.hellospring.Service;

import com.example.hellospring.Dto.StudentJoinRequest;
import com.example.hellospring.Dto.StudentResponse;
import com.example.hellospring.entitiy.Student;
import com.example.hellospring.repository.StudentRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor//롬복 생성자 자동으로 만듦
@Transactional(readOnly=true)//읽을 수만 있음
public class StudentService {
    //Service가 Repository 사용하기 위해 선언
    private final StudentRepository studentRepository;
    //학생 등록 처리 메소드
    @Transactional
    public Long join(StudentJoinRequest request){
        //중복 검증 로직(서비스)
        validateDuplicateStudent(request.getEmail());
        //저장 및 식별자 반환
        Student student=request.toEntity();
        return studentRepository.save(student).getId();
    }
    //중복검사 메소드
    private void validateDuplicateStudent(String email){
        studentRepository.findByEmail(email).ifPresent(m-> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }
    public StudentResponse findByEmail(String email){
        Student student=studentRepository.findByEmail(email).orElseThrow(()->new IllegalArgumentException("해당 이메일을 가진 학생이 없습니다."));
        return StudentResponse.from(student);
    }
    public List<StudentResponse> findAllStudents(){
        return studentRepository.findAll().stream().map(StudentResponse::from).collect(Collectors.toList());
    }

}
