package com.jinny7.restapipracitce.entity;

// JPA x -> 쌩자바 (엔티티 다는건 태현 튜터님 다락방에서~)
/* 학생에 어떤거 넣을지?
    1. ID (엔티티 고유번호)
    2. 학번 (e.g. 202451111)
    3. 이름
    4. 이메일
 */

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "students")
public class Student {
    /**
     * 1. ID (엔티티 고유번호)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 2. 학번 (e.g. 202451111)
     */
    @Column(name = "student_number", nullable = false, unique = true)
    private String studentNumber;
    /**
     * 3. 이름
     */
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 4. 이메일
     */
    @Column(name = "email", nullable = false)
    private String email;

//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<Exam> exams = new ArrayList<>();

    public Student(Long id, String studentNumber, String name, String email){
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
    }

}
