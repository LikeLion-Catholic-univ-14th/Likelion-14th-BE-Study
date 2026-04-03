package org.example.study_3.repository;

import org.example.study_3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
                                            //어떤 엔티티를 다룰지, 기본 타입
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    //optional이 student가 있을수도있고 없을수도잇다..
}
//DB 담당창구
//Student를 DB에 저장
//이메일로 Student 조회

