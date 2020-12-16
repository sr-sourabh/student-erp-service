package com.erp.student.student;

import com.erp.student.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRollNo(String rollNo);

    Long countAllByDomain(Domain domain);

    Student findFirstByOrderByRollNoDesc();

    Long countAllByEmail(String email);
}
