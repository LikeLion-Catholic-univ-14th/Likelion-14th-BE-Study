package com.example.hellospring.controller;

import com.example.hellospring.dto.StudentJoinRequest;
import com.example.hellospring.dto.StudentResponseDto;
import com.example.hellospring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    // 기존 등록 기능
    @PostMapping
    public ResponseEntity<String> register(@RequestBody StudentJoinRequest request) {
        studentService.join(request);
        return ResponseEntity.ok("등록 성공!");
    }

    // 전체 학생 조회
    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.findAllStudents());
    }

    // 이메일로 학생 조회
    @GetMapping("/email")
    public ResponseEntity<?> getStudentByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(studentService.findStudentByEmail(email));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}