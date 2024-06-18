package com.jinny7.restapipracitce.db;

// DB 대용 HashMap (임시용)

import com.jinny7.restapipracitce.dto.StudentRequestDto;
import com.jinny7.restapipracitce.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StudentMap {
    private Map<Long, Student> studentMap;

    public StudentMap() {
        this.studentMap = new ConcurrentHashMap<>();
    }

    //우리가 만든 API로 추가하면 학생이 하나씩 추가
    public void add(Long id, StudentRequestDto studentRequestDto) {
        Student student = this.converntDtoToStudent(studentRequestDto);
        this.studentMap.put(id, student);
    }

    //특정 ID의 Student를 가져오는 메소드
    public Student getById(Long id) {
        return this.studentMap.get(id);
    }

    //전체 조회용 메소드
    //리스트로 리턴해야 하니 스트림 통해 리스트로 변환
    public List<Student> getAll(){
        return this.studentMap.values().stream().toList();
    }

    //학번을 파라미터로 받아서 학번에 해당하는 학생을 조회하기의 메소드
    public Student getByNumber(String studentNumber){
        // Student list에서 studentNumber에 해당하는 Student 찾기
        List<Student> studentList = this.studentMap.values().stream()
                .filter(student -> student.getStudentNumber().equals(studentNumber))
                .toList();
        return studentList.get(0);
    }

    //Dto를 Student로 변환
    private Student converntDtoToStudent(StudentRequestDto studentRequestDto){
//        Student student = new Student(
//                studentRequestDto.getId(),
//                studentRequestDto.getStudentNumber(),
//                studentRequestDto.getName(),
//                studentRequestDto.getEmail()
//        );
//    return student;
// 아래와 동일 코드 (줄여쓰자!)
        return new Student(
                studentRequestDto.getId(),
                studentRequestDto.getStudentNumber(),
                studentRequestDto.getName(),
                studentRequestDto.getEmail()
        );
    }


}
