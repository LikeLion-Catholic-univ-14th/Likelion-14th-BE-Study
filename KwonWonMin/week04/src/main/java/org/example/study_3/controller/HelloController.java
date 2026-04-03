package org.example.study_3.controller;

import org.example.study_3.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }

    @GetMapping("/hello-dto")
    public HelloDto helloDto(){
        return new HelloDto("안녕하세요","권원민");
    }
}
