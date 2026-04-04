package org.example.week3_study.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String sayHello(String name) {
            return name + "님 안녕하세요!";
        }
    }
