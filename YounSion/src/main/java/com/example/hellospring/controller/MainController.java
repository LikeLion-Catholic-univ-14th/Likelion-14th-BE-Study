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
    @GetMapping("/plus/{number1}/{number2}")
    public String test2(@PathVariable int number1, @PathVariable int number2) {
        int number = number1 + number2;
        return "덧셈 결과는 = "+ number;

    }

}
