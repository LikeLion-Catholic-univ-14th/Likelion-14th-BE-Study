package com.example.hellospring.Controller;
import com.example.hellospring.Dto.StudentResponse;
import com.example.hellospring.repository.StudentRepository;
import com.example.hellospring.Dto.StudentJoinRequest;
import com.example.hellospring.Service.StudentService;
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
        studentService.join(request);//등록처리를 서비스에게 맡김
        return ResponseEntity.ok("등록 성공!");
    }
    @GetMapping("/api/students")
    public ResponseEntity<List<StudentResponse>> getStudents(){
        return ResponseEntity.ok(studentService.findAllStudents());
    }
    @GetMapping("/api/students/email")
    public ResponseEntity<?> getByEmail( @RequestParam String email){
       try{
           return ResponseEntity.ok(studentService.findByEmail(email));
       }catch (IllegalArgumentException e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

}
