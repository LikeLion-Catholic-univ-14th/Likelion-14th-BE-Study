package com.example.hello_spring.controller;

import com.example.hello_spring.dto.HelloDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
    @GetMapping("/hello-dto")
    public HelloDto helloDto() {
        return new HelloDto("안녕하세요", "홍지우");
    }
}
