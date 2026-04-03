package org.example.study_3.controller;

import org.example.study_3.dto.HelloDto;
import org.example.study_3.dto.IntroduceDto;
import org.example.study_3.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntroduceController {

    private final HelloService helloService;

    public IntroduceController(HelloService helloService){
        this.helloService = helloService;
    }
    @GetMapping("/intro")
    public IntroduceDto introduceDto(){
        return helloService.getIntroduceData();
    }
}
