package com.erp.student.student;

import com.erp.student.domain.Domain;
import com.erp.student.domain.DomainRepository;
import com.erp.student.dto.StudentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentServiceImpl implements StudentService {

    @Value("${erp.student.rollno.length}")
    private int rollNoLen;

    @Value(("${erp.student.image.path}"))
    private String imageBasePath;

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private DomainRepository domainRepository;

    @Resource
    private StudentTransformer studentTransformer;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> getAllStudents() {
        return studentTransformer.toStudentDtos(studentRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto getStudentDetailsByRollNo(String rollNo) {
        List<Student> students = new ArrayList<>();
        students.add(studentRepository.findByRollNo(rollNo));
        return studentTransformer.toStudentDtos(students).get(0);
    }

    @Override
    @Transactional
    public StudentDto editStudentDetails(StudentDto request) throws Exception {
        boolean isNew = Objects.isNull(request.getRollNo()) || request.getRollNo().isBlank();

        Student student;
        if (isNew) {
            checkDomainLimit(request.getDomainDto().getProgram());
            student = new Student();
            student.setRollNo(generateRollNo(request.getDomainDto().getProgram()));
        } else {
            student = studentRepository.findByRollNo(request.getRollNo());
            if (student == null) {
                throw new Exception("Student with rollNo: " + request.getRollNo() + " not found");
            }
        }
        checkDuplicateEmail(request);
        List<Student> students = new ArrayList<>();
        students.add(studentTransformer.toEntity(student, request));
        return studentTransformer.toStudentDtos(students).get(0);
    }

    @Override
    @Transactional
    public String uploadImage(MultipartFile imageFile) throws Exception {
        byte[] bytes = imageFile.getBytes();
        String imagePath = System.currentTimeMillis() + "";
        Path path = Paths.get(imageBasePath + imagePath);
        Files.write(path, bytes);
        return imagePath;
    }

    private void checkDuplicateEmail(StudentDto request) throws Exception {
        List<Student> students = studentRepository.findByEmail(request.getEmail());
        if (students.size() > 0 && (students.size() > 1 || !students.get(0).getRollNo().equals(request.getRollNo()))) {
            throw new Exception("Sorry duplicate email is not allowed");
        }
    }

    private void checkDomainLimit(String program) throws Exception {
        Domain domain = domainRepository.findByProgram(program);
        Long count = studentRepository.countAllByDomain(domain);
        if (count >= domain.getCapacity()) {
            throw new Exception("Sorry maximum domain capacity reached");
        }
    }

    private String generateRollNo(String program) {
        Domain domain = domainRepository.findByProgram(program);
        Student student = studentRepository.findFirstByOrderByRollNoDesc();
        if (student == null) {
            return domain.getProgram() + domain.getBatch() + "001";
        }
        String rollNo = student.getRollNo().substring(student.getRollNo().length() - rollNoLen);
        rollNo = String.valueOf(Integer.parseInt(rollNo) + 1);
        String newRollNo = rollNo;
        if (rollNo.length() < rollNoLen) {
            for (int i = 0; i < rollNoLen - rollNo.length(); i++) {
                newRollNo = "0" + newRollNo;
            }
        }
        return domain.getProgram() + domain.getBatch() + newRollNo;
    }
}
