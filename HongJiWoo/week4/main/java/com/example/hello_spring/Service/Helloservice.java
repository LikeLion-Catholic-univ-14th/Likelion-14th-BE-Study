package com.example.hello_spring.Service;

import com.example.hello_spring.dto.HelloDto;
import org.springframework.stereotype.Service;

@Service
public class Helloservice {

    public String sayHello(String name) {
        return name + "님 안녕하세요!";
    }
}
