package com.erp.student.student;

import com.erp.student.domain.Domain;
import com.erp.student.domain.DomainRepository;
import com.erp.student.domain.DomainTransformer;
import com.erp.student.dto.DomainDto;
import com.erp.student.dto.SpecialisationDto;
import com.erp.student.dto.StudentDto;
import com.erp.student.specialisation.Specialisation;
import com.erp.student.specialisation.SpecialisationRepository;
import com.erp.student.specialisation.SpecialisationTransformer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class StudentTransformer {

    @Resource
    private DomainTransformer domainTransformer;

    @Resource
    private SpecialisationTransformer specialisationTransformer;

    @Resource
    private DomainRepository domainRepository;

    @Resource
    private SpecialisationRepository specialisationRepository;

    @Resource
    private StudentRepository studentRepository;

    public List<StudentDto> toStudentDtos(List<Student> students) {
        if (Objects.isNull(students)) {
            return new ArrayList<>();
        }

        List<StudentDto> studentDtos = new ArrayList<>();
        students.forEach(student -> {
            if (Objects.nonNull(student)) {
                StudentDto studentDto = new StudentDto();
                studentDto.setRollNo(student.getRollNo());
                studentDto.setCgpa(student.getCgpa());
                studentDto.setEmail(student.getEmail());
                studentDto.setFirstName(student.getFirstName());
                studentDto.setLastName(student.getLastName());
                studentDto.setGraduationYear(String.valueOf(student.getGraduationYear().getYear()));
                studentDto.setTotalCredits(student.getTotalCredits());
                studentDto.setDeleted(student.isDeleted());

                DomainDto domainDto = domainTransformer.toDto(student.getDomain());
                studentDto.setDomainDto(domainDto);

                SpecialisationDto specialisationDto = specialisationTransformer.toDto(student.getSpecialisation());
                studentDto.setSpecialisationDto(specialisationDto);

                studentDtos.add(studentDto);
            } else {
                studentDtos.add(null);
            }
        });

        return studentDtos;
    }

    public Student toEntity(Student student, StudentDto request) {
        student.setCgpa(request.getCgpa());
        student.setEmail(request.getEmail());
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setPhotographPath(request.getImagePath());

        student.setGraduationYear(LocalDate.of(Integer.parseInt(request.getGraduationYear()), 1, 1));
        student.setTotalCredits(request.getTotalCredits());
        student.setDeleted(request.isDeleted());

        Domain domain = domainRepository.findByProgram(request.getDomainDto().getProgram());
        student.setDomain(domain);

        Specialisation specialisation = specialisationRepository.findByCode(request.getSpecialisationDto().getCode());
        student.setSpecialisation(specialisation);

        return studentRepository.saveAndFlush(student);
    }
}
