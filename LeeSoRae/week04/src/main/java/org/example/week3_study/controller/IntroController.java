package org.example.week3_study.controller;

import org.example.week3_study.dto.IntroDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntroController {

    @GetMapping("/intro")
    public IntroDto introDto() {
        return new IntroDto("이소래","컴퓨터정보공학부");
    }

}
