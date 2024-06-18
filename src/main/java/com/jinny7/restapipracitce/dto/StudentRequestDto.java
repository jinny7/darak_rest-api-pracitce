package com.jinny7.restapipracitce.dto;

import lombok.Getter;
@Getter
//클래스에 게터를 달면 밑에 4개에도 자동으로 게터가 생김
public class StudentRequestDto {
    /**
     * 1. ID (엔티티 고유번호)
     */
    private final Long id;
    /**
     * 2. 학번 (e.g. 202451111)
     */
    private final String studentNumber;
    /**
     * 3. 이름
     */
    private final String name;
    /**
     * 4. 이메일
     */
    private final String email;

    public StudentRequestDto(Long id, String studentNumber, String name, String email){
        this.id = id;
        this.studentNumber = studentNumber;
        this.name = name;
        this.email = email;
    }
}
