package org.example.week3_study.controller;

import lombok.RequiredArgsConstructor;
import org.example.week3_study.dto.CalcDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MathController {
    @GetMapping("/")
    public String link() {
        return "연결 성공";
    }

    @GetMapping("/add/{num1}/{num2}")
    public CalcDto add(@PathVariable int num1, @PathVariable int num2) {
        int result= num1 + num2;
        return new CalcDto(num1,num2,result);
    }

    @GetMapping("/sub/{num1}/{num2}")
    public CalcDto sub(@PathVariable int num1, @PathVariable int num2) {
        int result= num1 - num2;
        return new CalcDto(num1,num2,result);
    }

    @GetMapping("/mul/{num1}/{num2}")
    public CalcDto mul(@PathVariable int num1, @PathVariable int num2) {
        int result= num1 * num2;
        return new CalcDto(num1,num2,result);
    }

    @GetMapping("/div/{num1}/{num2}")
    public CalcDto div(@PathVariable int num1, @PathVariable int num2) {
        int result= num1 / num2;
        return new CalcDto(num1,num2,result);
    }
}

