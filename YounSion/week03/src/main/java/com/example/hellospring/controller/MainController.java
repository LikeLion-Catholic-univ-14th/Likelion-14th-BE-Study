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
    @GetMapping("/plus/{number1}/{number2}")
    public String test2(@PathVariable int number1, @PathVariable int number2) {
        int number = number1 + number2;
        return "덧셈 결과는 = "+ number;
    }

    // 뺄셈
    @GetMapping("/minus/{number1}/{number2}")
    public String minus(@PathVariable int number1, @PathVariable int number2) {
        int result = number1 - number2;
        return "뺄셈 결과 = " + result;
    }

    // 곱셈
    @GetMapping("/multiply/{number1}/{number2}")
    public String multiply(@PathVariable int number1, @PathVariable int number2) {
        int result = number1 * number2;
        return "곱셈 결과 = " + result;
    }

    // 나눗셈
    @GetMapping("/divide/{number1}/{number2}")
    public String divide(@PathVariable int number1, @PathVariable int number2) {
        if (number2 == 0) {
            return "0으로 나눌 수 없습니다!";
        }
        double result = (double) number1 / number2;
        return "나눗셈 결과 = " + result;
    }

}
