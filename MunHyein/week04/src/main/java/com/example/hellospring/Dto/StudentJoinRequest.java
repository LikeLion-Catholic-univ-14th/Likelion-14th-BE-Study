package com.example.hellospring.Dto;

import com.example.hellospring.entitiy.Student;

public class StudentJoinRequest {
    //사용자가 보내는 json키와 대응대는 데이터
    private String name;
    private String email;

    public StudentJoinRequest(){}//기본생성자
    public StudentJoinRequest(String name, String email){
        this.name=name;
        this.email=email;
    }
    //Dto -> Entity 변환하는 메소드
    public Student toEntity(){
        return new Student(name, email);
    }
    public String getName(){
        return name;
    }
    public String getEmail(){ return email;}
}
