package com.erp.student.student;

import com.erp.student.dto.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @ExceptionHandler(Exception.class)
    public StudentDto handleException(Exception e) {
        StudentDto studentDto = new StudentDto();
        studentDto.setError(e.getMessage());
        return studentDto;
    }

    @GetMapping(path = "/student/details")
    public List<StudentDto> getStudentDetails() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/student/details/{rollNo}")
    public StudentDto getStudentDetailsByRollNo(@PathVariable(value = "rollNo") String rollNo) {
        return studentService.getStudentDetailsByRollNo(rollNo);
    }

    @PostMapping(path = "/student/details/")
    public StudentDto editStudentDetails(@RequestParam("json") String requestString, @RequestParam(value = "file", required = false) MultipartFile imageFile) throws Exception {
        String imagePath = imageFile == null ? null : studentService.uploadImage(imageFile);
        StudentDto request = new ObjectMapper().readValue(requestString, StudentDto.class);
        request.setImagePath(imagePath);
        return studentService.editStudentDetails(request);
    }
}
