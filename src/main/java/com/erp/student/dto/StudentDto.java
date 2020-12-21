package com.erp.student.dto;

import lombok.Data;

@Data
public class StudentDto {
    private String rollNo;
    private String firstName;
    private String lastName;
    private String email;
    private Double cgpa;
    private Long totalCredits;
    private String graduationYear;
    private DomainDto domainDto;
    private SpecialisationDto specialisationDto;
    private String error;
    private boolean isDeleted;
    private String imagePath;
}
