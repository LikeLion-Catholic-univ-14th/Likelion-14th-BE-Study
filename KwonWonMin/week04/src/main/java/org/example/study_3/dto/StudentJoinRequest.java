package org.example.study_3.dto;

import org.example.study_3.entity.Student;

public class StudentJoinRequest {

    //사용자가 보내는 JSON 키와 대응됨
    private String name;
    private String email;

    public StudentJoinRequest(){}
    public StudentJoinRequest(String name, String email){
        this.name=name;
        this.email=email;
    }
    //DTO를 Entity로 바꾸는 메서드
    public Student toEntity(){
        return new Student(name, email);
    }
    //getter 메서드
    public String getName(){
        return  name;
    }
    public String getEmail() { return email; }
}
