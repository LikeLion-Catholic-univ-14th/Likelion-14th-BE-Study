package com.example.hellospring.controller;

import com.example.hellospring.dto.StudentJoinRequest;
import com.example.hellospring.repository.StudentRepository;
import com.example.hellospring.service.StudentService;//추가
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/api/students")
    public ResponseEntity<String> register(@RequestBody StudentJoinRequest request){
        studentService.join(request);//등록처리 - Service한테 맡김
        return ResponseEntity.ok("등록 성공!");
    }


}
