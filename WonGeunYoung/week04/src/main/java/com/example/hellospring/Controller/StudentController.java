package com.example.hellospring.Controller;

import com.example.hellospring.entity.Student;
import com.example.hellospring.service.StudentService;
import dto.StudentJoinRequest;
import dto.StudentResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/api/students")
    public ResponseEntity<String> register(@RequestBody StudentJoinRequest request){
        studentService.join(request);
        return ResponseEntity.ok("등록 성공!");
    }

    @GetMapping("/api/students")
    public ResponseEntity<List<StudentResponseDto>> getAllStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
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
