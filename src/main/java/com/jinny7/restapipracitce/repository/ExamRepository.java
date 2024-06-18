package com.jinny7.restapipracitce.repository;

import com.jinny7.restapipracitce.entity.Exam;
import com.jinny7.restapipracitce.entity.SubjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    List<Exam> findByStudentIdAndSubjectType(Long studentId, SubjectType subjectType);
}
