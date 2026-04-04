package org.example.week3_study.service;

import org.example.week3_study.dto.StudentResponse;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.week3_study.dto.StudentJoinRequest;
import org.example.week3_study.entity.Student;
import org.example.week3_study.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor //롬복이 생성자를 자동으로 만들어줌
@Transactional(readOnly= true)
public class StudentService {
    //서비스가 레파지토리를 사용하기 위해 선언한 필드
    private final StudentRepository studentRepository;
    
    //학생 등록 처리 메서드
    @Transactional
    public long join(StudentJoinRequest request) {
        vaildateDuplicatedStudent(request.getEmail()); //중복 검증 로직 - 서비스의 역할
        
        Student student = request.toEntity(); //저장 및 식별자 반환
        return studentRepository.save(student).getId();
    }
    //중복 검사 메서드
    private void vaildateDuplicatedStudent(String email) {
        studentRepository.findByEmail(email)
                .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 회원입니다.");});
    }

    //모든 학생 조회 메서드
    public List<StudentResponse> findAllStudents(){
        Iterable<Student> allStudents = studentRepository.findAll();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (Student student : allStudents) {
            StudentResponse studentResponse = new StudentResponse(student.getName(), student.getEmail());
            studentResponseList.add(studentResponse);
        }
        return studentResponseList;
    }

    public StudentResponse findByEmail(String email){
        Student student= studentRepository.findByEmail(email)
                .orElseThrow( ()-> new IllegalStateException("해당 이메일의 학생이 없습니다."));
        return new StudentResponse(student.getName(), student.getEmail());

    }

}
