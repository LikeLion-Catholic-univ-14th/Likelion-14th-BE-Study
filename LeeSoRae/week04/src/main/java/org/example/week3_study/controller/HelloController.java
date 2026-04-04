package org.example.week3_study.controller;

import lombok.RequiredArgsConstructor;
import org.example.week3_study.dto.HelloDto;
import org.example.week3_study.dto.IntroDto;
import org.example.week3_study.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;  //API 컨트롤러 선언

@RestController //해당 클래스가 데이터를 반환하는 컨트롤러임을 스프링에 알림
public class HelloController {//사용자 요청 받아 처리
//
//    @GetMapping("/hello") //브라우저에서 이 경로로 접속했을 때 이 메소드를 실행하게함
//    public String hello(){
//        return "Hello Spring Boot!";
//    }
    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return helloService.sayHello(name);
    }

}
