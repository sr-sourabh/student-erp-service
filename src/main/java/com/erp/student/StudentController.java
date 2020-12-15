package com.erp.student;

import com.erp.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping(path = "/student/details")
    public List<StudentDto> getStudentDetails() {
        return studentService.getAllStudents();
    }

}
