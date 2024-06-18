package com.jinny7.restapipracitce.controller;

import com.jinny7.restapipracitce.entity.Exam;
import com.jinny7.restapipracitce.entity.SubjectType;
import com.jinny7.restapipracitce.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {
    @Autowired
    private ExamService examService;

    // 시험 생성
    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody Exam exam) {
        return ResponseEntity.ok(examService.createExam(exam));
    }

    // 등록한 학생의 과목타입(JPA) 과목 시험을 조회
    @GetMapping("/student/{studentId}/subject/{subjectType}")
    public ResponseEntity<List<Exam>> getExams(@PathVariable Long studentId, @PathVariable SubjectType subjectType) {
        return ResponseEntity.ok(examService.getExamsByStudentIdAndSubjectType(studentId, subjectType));
    }
}
