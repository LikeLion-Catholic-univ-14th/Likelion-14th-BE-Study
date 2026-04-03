package org.example.study_3.service;

import org.example.study_3.dto.IntroduceDto;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public IntroduceDto getIntroduceData() {
        String myName = "권원민";
        String myMajor = "컴퓨터정보공학부";

        return new IntroduceDto(myName,myMajor);
    }
}
