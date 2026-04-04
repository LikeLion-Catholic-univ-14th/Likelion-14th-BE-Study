package org.example.week3_study.dto;

import org.example.week3_study.entity.Student;

public class StudentJoinRequest {
    private String name;
    private String email;

    //사용자가 보내는 JSON 키와 대응
    public StudentJoinRequest() {} //기본생성자
    public StudentJoinRequest(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //Dto를 엔티티로 바꾸는 메서드
    public Student toEntity(){

        return new Student(name, email); //요청한 데이터를 객체로 만듦
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
