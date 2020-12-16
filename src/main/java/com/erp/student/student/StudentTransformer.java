package com.erp.student.student;

import com.erp.student.dto.StudentDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentTransformer {
    public List<StudentDto> toStudentDtos(List<Student> students) {
        if (Objects.isNull(students)) {
            return new ArrayList<>();
        }

        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(student -> {
            StudentDto studentDto = new StudentDto();
            studentDto.setRollNo(student.getRollNo());
            studentDto.setCgpa(student.getCgpa());
            studentDto.setEmail(student.getEmail());
            studentDto.setFirstName(student.getFirstName());
            studentDto.setLastName(student.getLastName());
            studentDto.setGraduationYear(student.getGraduationYear());
            studentDto.setTotalCredits(student.getTotalCredits());
            studentDtos.add(studentDto);
        });

        return studentDtos;
    }
}
