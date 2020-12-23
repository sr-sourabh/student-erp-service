package com.erp.student.student;

import com.erp.student.dto.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    @PutMapping(path = "/student/details/query")
    public List<StudentDto> getStudentDetailsByQuery(@RequestBody String query) {
        return studentService.getStudentDetailsByQuery(query);
    }

    @GetMapping(path = "/student/details")
    public List<StudentDto> getStudentDetails() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/student/details/{rollNo}")
    public StudentDto getStudentDetailsByRollNo(@PathVariable(value = "rollNo") String rollNo) {
        return studentService.getStudentDetailsByRollNo(rollNo);
    }

    @PostMapping(path = "/student/details")
    public StudentDto editStudentDetails(@RequestParam("json") String requestString, @RequestParam(value = "file", required = false) MultipartFile imageFile) throws Exception {
        StudentDto request = new ObjectMapper().readValue(requestString, StudentDto.class);
        validateRequest(request);
        String imagePath = imageFile == null ? null : studentService.uploadImage(imageFile);
        request.setImagePath(imagePath);
        return studentService.editStudentDetails(request);
    }

    private void validateRequest(StudentDto request) throws Exception {
        if (Strings.isBlank(request.getEmail())) {
            throw new Exception("Email should not be blank");
        } else if (Strings.isBlank(request.getFirstName())) {
            throw new Exception("First name should not be blank");
        } else if (Objects.isNull(request.getCgpa())) {
            throw new Exception("Cgpa should not be blank");
        } else if (Objects.isNull(request.getGraduationYear())) {
            throw new Exception("Graduation year should not be blank");
        } else if (Strings.isBlank(request.getDomainDto().getProgram())) {
            throw new Exception("Program should not be blank");
        } else if (Objects.isNull(request.getSpecialisationDto().getCode())) {
            throw new Exception("Code should not be blank");
        } else if (Objects.isNull(request.getTotalCredits())) {
            throw new Exception("Credits should not be blank");
        }
    }
}
