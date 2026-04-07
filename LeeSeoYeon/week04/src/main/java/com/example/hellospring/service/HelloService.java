package com.example.hellospring.service; //HelloService 클래스가 어떤 폴더, 구조 안에 있는지 선언하는 것이다.

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String formatMessage(String name) {
        return "Hello, " + name + "!";
    }
}
