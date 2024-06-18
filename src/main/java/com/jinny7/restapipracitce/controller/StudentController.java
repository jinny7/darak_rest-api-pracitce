package com.jinny7.restapipracitce.controller;

import ch.qos.logback.core.util.StringUtil;
import com.jinny7.restapipracitce.db.StudentMap;
import com.jinny7.restapipracitce.dto.StudentRequestDto;
import com.jinny7.restapipracitce.entity.Student;
import com.jinny7.restapipracitce.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentMap studentMap;

    public StudentController(StudentMap studentMap) {
        this.studentMap = studentMap;
    }

    @Autowired
    private StudentService studentService;

    // 1. 학생 등록
    // 호출할 때 POST로 /sudents하고 RequestBody에 JSON형태로 쓰면 호출됨
    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        this.studentMap.add(studentRequestDto.getId(), studentRequestDto);

        //ResponseEntity로 무엇을 넘겨줄 것인가 : 등록완료 메세지
        return ResponseEntity.status(HttpStatus.CREATED).body("학생 등록이 완료되었습니다.");
    }
    // 모든 리스폰스를 리스폰스엔티티로


    // 2. id로 학생 조회
    // 호출할 때 GET로 /sudents하고 {id}쓰면 관련 내용을 response로 줄겨
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id){
        Student student = this.studentMap.getById(id);
        return studentService.getStudent(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    // 3. 학생 전체 조회
    // &
    // 4.학번을 파라미터로 받아서 학번에 해당하는 학생을 조회하기
    // (GET) /students?number=20215190
    @GetMapping
    public ResponseEntity<?> getStudents(
            @RequestParam(value = "number", required = false) String studentNumber){
        //RequestParam이 필수가 아니다 : required = false
        if (StringUtils.hasLength(studentNumber)) {
            Student student = this.studentMap.getByNumber(studentNumber);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }

        List<Student> studentList = this.studentMap.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(studentList);
    }

    /*
    URL로 입력받는 방법
    1. path -> /students/1
    path라고 부르는 거  /students/1
    ex1. http://localhost:8080/students/1
         /students/1
         -> @PathVariable Long id 로 받음
    ex2. http://localhost:8080/students/2
         /students/2
         -> @PathVariable Long studentId, @PathVariable Long subjectId 로 받음
         -> 실제 사용 할 때 :
         @GetMapping("/{studentId}/subjects/{subjectId}")
            public ResponseEntity<?> getStudentById(
            @PathVariable Long studentId,
            @PathVariable Long subjectId)

    2. parameter -> /students?number=20245190
    parameter라고 부르는거  ?number=20245190
    ex1. 파라미터가 하나일 때
        http://localhost:8080/students?number=20243333
        -> 실제 사용 할 때 :
            @GetMapping
            public ResponseEntity<?> getStudents(
                @RequestParam String studentNumber)
        -> 참고, 실제값이 할 때 :
            (value = "number", required = false)
    ex2. 파라미터가 두개일 때
        http://localhost:8080/students?number=20243333&name=니니
        -> 실제 사용 할 때 :
            public ResponseEntity<?> sample(
            @RequestParam String studentNumber,
            @RequestParam String name
            )
     */
}
