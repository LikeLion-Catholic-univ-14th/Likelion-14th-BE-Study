package com.example.hellospring.controller;

import com.example.hellospring.dto.HelloDto; //dto 만들고 추가
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
    @GetMapping("/hello-dto") //문자열 반환에서 객체 반환으로 확장
    public HelloDto helloDto(){
        return new HelloDto("안녕하세요", "윤시온");
    }
}