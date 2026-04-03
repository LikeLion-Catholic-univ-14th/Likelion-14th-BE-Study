package org.example.study_3.controller;

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
    @GetMapping("/add/{num1}/{num2}")
    public String add(@PathVariable int num1, @PathVariable int num2) {
        int result = num1 + num2;
        return num1 + " + " + num2 + " = " + result;
    }
    @GetMapping("/sub/{num1}/{num2}")
    public String sub(@PathVariable int num1, @PathVariable int num2){
        int result = num1 - num2;
        return num1 + " - " + num2 + " = "+ result;
    }
    @GetMapping("/mul/{num1}/{num2}")
    public String mul(@PathVariable int num1, @PathVariable int num2){
        int result = num1 * num2;
        return num1 + " * " + num2 + " = " + result;
    }
    @GetMapping("/div/{num1}/{num2}")
    public String div(@PathVariable float num1, @PathVariable float num2){
        float result = num1 / num2;
        return num1 + " / " + num2 + " = " + result;
    }
}
