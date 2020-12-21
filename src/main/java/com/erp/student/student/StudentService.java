package com.erp.student.student;

import com.erp.student.dto.StudentDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentDetailsByRollNo(String rollNo);

    StudentDto editStudentDetails(StudentDto request) throws Exception;

    //return path of the file stored
    String uploadImage(MultipartFile imageFile) throws Exception;

    String retrieveImage(String imagePath) throws Exception;
}
