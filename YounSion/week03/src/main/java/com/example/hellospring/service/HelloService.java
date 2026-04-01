package com.example.hellospring.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String processMessage(String nickname){
        return "안녕하세요, " + nickname + "님. 이건 서비스에서 가공된 메세지입니당";
    }
}
