package dto;

import com.example.hellospring.entity.Student;

public class StudentJoinRequest {


    // 사용자가 보내는 Json 키와 대응됨
    private String name;
    private String email;


    public StudentJoinRequest() {} // 기본 생성자

    public StudentJoinRequest(String name, String email) {
     this.name = name;
     this.email = email;
    }

    // Dto를 Entity로 바꾸는 메소드
    public Student toEntity() {
        return new Student(name, email);
    }

    //게터 메서드
    public String getName(){
        return name;
    }

    public String getEmail(){
        return  email;
    }

}
