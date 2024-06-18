package com.jinny7.restapipracitce.service;

import com.jinny7.restapipracitce.entity.Exam;
import com.jinny7.restapipracitce.entity.SubjectType;
import com.jinny7.restapipracitce.repository.ExamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepository examRepository;

    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam); // 시험 생성
    }

    public List<Exam> getExamsByStudentIdAndSubjectType(Long studentId, SubjectType subjectType) {
        return examRepository.findByStudentIdAndSubjectType(studentId, subjectType); // 시험 조회
    }
}
