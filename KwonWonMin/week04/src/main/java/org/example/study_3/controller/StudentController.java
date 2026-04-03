package org.example.study_3.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.study_3.dto.StudentJoinRequest;
import org.example.study_3.dto.StudentResponseDto;
import org.example.study_3.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    //엔티티 대신에 DTO를 파라미터로 받음
    //회원가입
    @PostMapping("/api/students")
    public ResponseEntity<String> register(@RequestBody StudentJoinRequest request){
        studentService.join(request); //등록처리 - Service한테 맡김
        return ResponseEntity.ok("등록성공!");
    }

    //전체 조회
    @GetMapping("/api/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    //이메일 조회
    @GetMapping("/api/students/email")
    public ResponseEntity<StudentResponseDto> getStudentByEmail(@RequestParam String email){
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

}
