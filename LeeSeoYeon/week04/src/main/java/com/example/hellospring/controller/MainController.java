package com.example.hellospring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String link() {
        return "연결 성공";
    }

    //덧셈
    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b) {
        return a + " + " + b + " = " + (a + b);
    }


    //뺄셈
    @GetMapping("/sub/{a}/{b}")
    public String plus(@PathVariable int a, @PathVariable int b) {
        return a + " - " + b + " = " + (a - b);
    }

    //곱셈
    @GetMapping("/mul/{a}/{b}")
    public String mul(@PathVariable int a, @PathVariable int b) {
        return a + " * " + b + " = " + (a * b);
    }

    //나눗셈 ( 0 나누기는 예외 처리 )
    @GetMapping("/div/{a}/{b}")
    public String div(@PathVariable int a, @PathVariable int b) {
        if (b == 0) {
            return "0으로 나눌 수 없습니다.";
        }
        return a + " / " + b + " = " + (a / (double) b);
    }
}
