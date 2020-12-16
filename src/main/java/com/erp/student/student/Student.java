package com.erp.student.student;

import com.erp.student.domain.Domain;
import com.erp.student.specialisation.Specialisation;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
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
    private Long graduationYear;

    @ManyToOne
    @JoinColumn(name = "domain", nullable = false)
    private Domain domain;

    @ManyToOne
    @JoinColumn(name = "specialisation", nullable = false)
    private Specialisation specialisation;

}
