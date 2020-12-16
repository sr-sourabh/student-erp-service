package com.erp.student.domain;

import com.erp.student.student.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainId;

    @NotNull
    @Column
    private String program;

    @NotNull
    @Column
    private Long batch;

    @NotNull
    @Column
    private Long capacity;

    @Column
    private String qualification;

    @OneToMany(mappedBy = "domain")
    private Set<Student> students;

}
