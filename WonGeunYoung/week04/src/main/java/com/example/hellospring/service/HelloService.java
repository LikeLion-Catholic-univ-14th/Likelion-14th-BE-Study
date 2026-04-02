package com.example.hellospring.service;

import dto.CalculateDto;
import dto.HelloDto;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloDto getMyIntro(){

        return new HelloDto("안녕하세요", "원근영", "컴공");
    }


    public CalculateDto add(int num1, int num2) {
        // result 자리에 num1 + num2를 넣어서 DTO를 만듭니다.
        return new CalculateDto(num1, num2, num1 + num2, "add");
    }

    public CalculateDto sub(int num1, int num2) {
        return new CalculateDto(num1, num2, num1 - num2, "sub");
    }

    public CalculateDto multiply(int num1, int num2) {
        return new CalculateDto(num1, num2, num1 * num2, "multiply");
    }

    public CalculateDto divide(int num1, int num2) {
        return new CalculateDto(num1, num2, num1 / num2, "divide");
    }

}
