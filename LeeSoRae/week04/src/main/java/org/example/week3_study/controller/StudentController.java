package org.example.week3_study.controller;

import lombok.RequiredArgsConstructor;
import org.example.week3_study.dto.StudentJoinRequest;
import org.example.week3_study.dto.StudentResponse;
import org.example.week3_study.entity.Student;
import org.example.week3_study.repository.StudentRepository;
import org.example.week3_study.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/studentjoin")
    public ResponseEntity<String> register (@RequestBody StudentJoinRequest request){
        studentService.join(request); //등록처리-서비스에게 맡김
        return ResponseEntity.ok("등록 성공!");
    }

  @GetMapping("/api/students")
    public ResponseEntity<List<StudentResponse>> getAllStudents(){
        List <StudentResponse> dtos = studentService.findAllStudents();
        return ResponseEntity.ok(dtos);
  }

  @GetMapping("/api/students/email")
    public ResponseEntity <StudentResponse> getStudentByEmail(@RequestParam("email") String email){
        StudentResponse dto = studentService.findByEmail(email);
        return ResponseEntity.ok(dto);
  }
}
