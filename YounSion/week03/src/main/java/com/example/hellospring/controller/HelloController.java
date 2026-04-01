package com.example.hellospring.controller;

import com.example.hellospring.dto.HelloDto; //dto 만들고 추가
import com.example.hellospring.dto.IntroDto;
import com.example.hellospring.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor //final이 붙은 필드에 대해 생성자 자동으로 생성해줘서 DI가 된다
public class HelloController {

    private final HelloService helloService; //필드 (생성자 주입)
    // final이 붙은 필드는 객체가 생성될 때 반드시 값이 채워져야 함
    //HelloController를 만들려면 HelloService가 꼭 필요하구나!

    @GetMapping("/hello-service")
    public String helloWithService(){
        return helloService.processMessage("시온");
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
    @GetMapping("/hello-dto") //문자열 반환에서 객체 반환으로 확장
    public HelloDto helloDto(){
        return new HelloDto("안녕하세요", "윤시온");

    }
    @GetMapping("/intro")
    public IntroDto intro(){
        return new IntroDto("윤시온", "컴퓨터정보공학부");
    }
}