package org.example.week3_study.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter //롬복 기능
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본생성자 生

public class Student {
    @Id//이 필드가 기본키라는 의미
    @GeneratedValue //id 안넣어도 DB가 자동으로 만들어줌

    private long id;

    private String name;
    private String email;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
