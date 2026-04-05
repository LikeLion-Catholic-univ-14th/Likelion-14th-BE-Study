package com.example.hellospring.controller;

import com.example.hellospring.dto.StudentJoinRequest;
import com.example.hellospring.dto.StudentResponseDto;
import com.example.hellospring.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody StudentJoinRequest request) {
        studentService.join(request);
        return ResponseEntity.ok("등록 성공!");
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/email")
    public ResponseEntity<?> getStudentByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(studentService.getStudentByEmail(email));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}