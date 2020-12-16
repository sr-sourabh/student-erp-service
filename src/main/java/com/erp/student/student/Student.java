package com.erp.student.student;

import com.erp.student.domain.Domain;
import com.erp.student.specialisation.Specialisation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Where(clause = "is_deleted = false")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column
    private Long studentId;

    @NotNull
    @Column(unique = true)
    private String rollNo;

    @NotNull
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column
    private String photographPath;

    @NotNull
    @Column
    private Long cgpa;

    @Column
    @NotNull
    private Long totalCredits;

    @Column
    private LocalDate graduationYear;

    @ManyToOne
    @JoinColumn(name = "domain", nullable = false)
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "specialisation", nullable = false)
    private Specialisation specialisation;

    @Column
    private boolean isDeleted = false;

}
