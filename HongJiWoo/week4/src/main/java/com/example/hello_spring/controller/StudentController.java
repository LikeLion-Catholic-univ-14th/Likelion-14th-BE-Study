package com.example.hello_spring.controller;

import com.example.hello_spring.dto.StudentJoinRequest;
import com.example.hello_spring.Service.StudentService;
import com.example.hello_spring.dto.StudentResponseDto;
import com.example.hello_spring.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// StudentController.java
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/students")
    public ResponseEntity<String> register(@RequestBody StudentJoinRequest request) {
        // Entity 대신 DTO를 파라미터로 받음
        studentService.join(request);
        return ResponseEntity.ok("등록 성공!");
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    @GetMapping("/api/students/email")
    public ResponseEntity<?> getStudentByEmail(@RequestParam String email) {
        try {
            StudentResponseDto response = studentService.findByEmail(email);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
