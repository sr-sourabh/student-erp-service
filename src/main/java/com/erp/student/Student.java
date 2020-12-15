package com.erp.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long studentId;

    @NotNull
    @Column(unique = true, name = "roll_no")
    private String rollNo;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "photograph_path")
    private String photographPath;

    @NotNull
    @Column(name = "cgpa")
    private Long cgpa;

    @Column(name = "total_credits")
    @NotNull
    private Long totalCredits;

    @Column
    private Long graduationYear;

}
