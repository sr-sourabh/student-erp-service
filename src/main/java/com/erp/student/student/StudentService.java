package com.erp.student.student;

import com.erp.student.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentDetailsByRollNo(String rollNo);

    StudentDto editStudentDetails(StudentDto request) throws Exception;
}
