package com.example.hello_spring.controller;

import com.example.hello_spring.dto.Intro_DTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Intro_Controller {
    @GetMapping("/intro")
    public Intro_DTO Intro_DTO() {
        return new Intro_DTO("홍지우", "컴퓨터정보공학부");
    }
}

