package com.jinny7.restapipracitce.repository;

import com.jinny7.restapipracitce.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentNumberAndEmail(String studentNumber, String email);

    List<Student> findByNameStartingWith(String prefix);
}


