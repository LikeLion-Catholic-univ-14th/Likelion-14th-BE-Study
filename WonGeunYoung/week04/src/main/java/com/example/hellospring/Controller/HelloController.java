package com.example.hellospring.Controller;

import dto.HelloDto;
import com.example.hellospring.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }

    @GetMapping("/hello/dto")
    public HelloDto helloDto(){
        return new HelloDto("안녕하세요", "원근영 ");
    }

public HelloController(HelloService helloService){
        this.helloService = helloService;

}
@GetMapping("/intro")
    public HelloDto hellointro(){
        return helloService.getMyIntro();
}

}
