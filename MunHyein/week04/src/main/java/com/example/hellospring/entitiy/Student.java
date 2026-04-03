package com.example.hellospring.entitiy;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter//롬복기능(getter 생성)
@NoArgsConstructor(access = AccessLevel.PROTECTED)//기본생성자
public class Student {
    @Id//이 필드가 기본키라는 의미
    @GeneratedValue//id값이 설정되지 않아도 DB가 자동으로 생성함
    private Long id;
    private String name;
    private String email;

    public Student(String name, String email){
        this.name=name;
        this.email=email;
    }

}
