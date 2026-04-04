package org.example.week3_study.repository;

import org.example.week3_study.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Long> { //long은 기본키의 자료형>
    Optional<Student> findByEmail(String email);

}
//레포지토리는 디비담당 창구
//Entity에 의해 생성된 DB 테이블에 접근하는 메서드들을 사용하기 위한 인터페이스