package com.erp.student.student;

import com.erp.student.dto.DomainDto;
import com.erp.student.dto.SpecialisationDto;
import com.erp.student.dto.StudentDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @InjectMocks
    private StudentController underTest;

    @Mock
    private StudentService studentService;

    @Test
    void editStudentDetails() throws Exception {
        MultipartFile imageFile = new MockMultipartFile("ss", new byte[2]);
        StudentDto studentDto = new StudentDto();
        studentDto.setFirstName("Shourabh");
        studentDto.setCgpa(4D);
        studentDto.setEmail("test@test.com");
        studentDto.setTotalCredits(22L);
        SpecialisationDto specialisationDto = new SpecialisationDto();
        specialisationDto.setCode(1L);
        studentDto.setSpecialisationDto(specialisationDto);
        DomainDto domainDto = new DomainDto();
        domainDto.setProgram("MT");
        studentDto.setDomainDto(domainDto);
        studentDto.setGraduationYear("1999");
        studentDto.setImagePath("/mockedPath/home");

        Mockito.when(studentService.uploadImage(imageFile)).thenReturn("/mockedPath/home");
        Mockito.when(studentService.editStudentDetails(studentDto)).thenReturn(studentDto);

        String json = new ObjectMapper().writeValueAsString(studentDto);
        StudentDto result = underTest.editStudentDetails(json, imageFile);

        Assertions.assertEquals(studentDto, result);

    }

    @Test
    void validateUniqueEmail() throws Exception {
        StudentDto studentDto = new StudentDto();
        Mockito.when(studentService.validateUniqueEmail(studentDto)).thenReturn(studentDto);
        StudentDto result = underTest.validateUniqueEmail(studentDto);
        Assertions.assertEquals(studentDto, result);
    }

    @Test
    void getStudentDetailsByQuery() {
        String query = "MT2020054";
        StudentDto studentDto = new StudentDto();
        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(studentDto);
        Mockito.when(studentService.getStudentDetailsByQuery(query)).thenReturn(studentDtos);
        List<StudentDto> result = underTest.getStudentDetailsByQuery(query);
        Assertions.assertEquals(studentDtos, result);
    }

    @Test
    void getStudentDetails() {
        StudentDto studentDto = new StudentDto();
        List<StudentDto> studentDtos = new ArrayList<>();
        studentDtos.add(studentDto);
        Mockito.when(studentService.getAllStudents()).thenReturn(studentDtos);
        List<StudentDto> result = underTest.getStudentDetails();
        Assertions.assertEquals(studentDtos, result);
    }
}