package com.erp.student.student;

import com.erp.student.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "/student/details/")
    public StudentDto editStudentDetails(@RequestBody StudentDto request) throws Exception {
        return studentService.editStudentDetails(request);
    }
}
