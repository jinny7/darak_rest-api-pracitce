package com.jinny7.restapipracitce.service;

import com.jinny7.restapipracitce.entity.Student;
import com.jinny7.restapipracitce.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student); // 학생 생성
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id); // 학생 조회
    }
}
