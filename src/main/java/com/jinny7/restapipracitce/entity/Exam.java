package com.jinny7.restapipracitce.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    private Float score;
    private com.jinny7.restapipracitce.entity.SubjectType subjectType;
    private LocalDateTime examDate;

    public Exam(Student student, Float score, com.jinny7.restapipracitce.entity.SubjectType subjectType, LocalDateTime examDate) {
        this.student = student;
        this.score = score;
        this.subjectType = subjectType;
        this.examDate = examDate;
    }
}
