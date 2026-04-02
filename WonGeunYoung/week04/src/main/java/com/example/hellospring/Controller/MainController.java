package com.example.hellospring.Controller;


import dto.CalculateDto;
import lombok.RequiredArgsConstructor;
import com.example.hellospring.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final HelloService helloService;

    @GetMapping("/")
    public String link(){
        return "연결 성공";
    }

    @GetMapping("/add/{num1}/{num2}")
    public CalculateDto add(@PathVariable("num1") int n1, @PathVariable("num2") int n2) {
        return helloService.add(n1, n2);
    }

    @GetMapping("/sub/{num1}/{num2}")
    public CalculateDto sub(@PathVariable("num1") int n1, @PathVariable("num2") int n2) {
        return helloService.sub(n1, n2);
    }

    @GetMapping("/multiply/{num1}/{num2}")
    public CalculateDto multiply(@PathVariable("num1") int n1, @PathVariable("num2") int n2) {
        return helloService.multiply(n1, n2);
    }

    @GetMapping("/divide/{num1}/{num2}")
    public CalculateDto divide(@PathVariable("num1") int n1, @PathVariable("num2") int n2) {
        return helloService.divide(n1, n2);
    }



}
