package com.example.hellospring.dto;

import com.example.hellospring.entity.Student;

public class StudentJoinRequest {

    //학생 등록 요청에 필요한 데이터.
    //사용자가 보내는 JSON 키와 대응됨
    private String name;
    private String email;

    public StudentJoinRequest() {} //기본 생성자
    public StudentJoinRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //DTO를 Entity로 바꾸는 메서드
    public Student toEntity(){
        return new Student(name, email);
    }

    //게터 메서드
    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
