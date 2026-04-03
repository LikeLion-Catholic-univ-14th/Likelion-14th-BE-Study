package org.example.study_3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter //롬복기능 getter 만들어줌
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자를 만들어줌 lombok 어노테이션
public class Student {
    @Id //이 필드가 기본키라는 의미
    @GeneratedValue //id 값 안넣어도 DB가 자동으로 만들어줌
    private Long id;

    private String name;
    private String email;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
    }
}
