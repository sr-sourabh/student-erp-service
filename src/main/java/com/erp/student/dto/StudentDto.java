package com.erp.student.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String rollNo;
    private String firstName;
    private String lastName;
    private String email;
    private Long cgpa;
    private Long totalCredits;
    private Long graduationYear;
}
