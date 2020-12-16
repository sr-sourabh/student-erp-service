package com.erp.student.student;

import com.erp.student.dto.StudentDto;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private StudentTransformer studentTransformer;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentTransformer.toStudentDtos(studentRepository.findAll());
    }
}
