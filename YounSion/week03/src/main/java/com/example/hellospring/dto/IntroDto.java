package com.example.hellospring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor //생성자 자동으로 만들어주는 어노테이션
public class IntroDto {
    private String name;
    private String major;

    public IntroDto() { //기본 생성자
    }

    //객체를 만들 때 값을 바로 넣기 위한 생성자
    public IntroDto(String name,String major) {
        this.name = name;
        this.major = major;
    }

    //데이터 읽기 위한 메소드. 외부에서 message에 직접 접근 못하고 이 메소드 통해서만 값을 가져올 수 있음
    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }


}
