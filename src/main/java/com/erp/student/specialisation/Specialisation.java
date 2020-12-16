package com.erp.student.specialisation;

import com.erp.student.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialisationId;

    @Column
    @NotNull
    private Long code;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    private String year;

    @Column
    private Long creditsRequired;

    @OneToMany(mappedBy = "specialisation")
    private Set<Student> students;

}
