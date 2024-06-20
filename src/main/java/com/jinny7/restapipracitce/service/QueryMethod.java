package com.jinny7.restapipracitce.service;

import com.jinny7.restapipracitce.entity.Exam;
import com.jinny7.restapipracitce.entity.Student;
import com.jinny7.restapipracitce.repository.ExamRepository;
import com.jinny7.restapipracitce.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryMethod {
    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentByStudentNumberAndEmail(String studentNumber, String email) {
        return studentRepository.findByStudentNumberAndEmail(studentNumber, email);
    }

    public List<Student> findStudentsByNameStartingWith(String prefix) {
        return studentRepository.findByNameStartingWith(prefix);
    }

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> findExamsByScoreBetweenOrderByScoreDesc(int minScore, int maxScore) {
        return examRepository.findByScoreBetweenOrderByScoreDesc(minScore, maxScore);
    }

}
