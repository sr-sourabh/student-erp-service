package com.erp.student.student;

import com.erp.student.domain.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByRollNo(String rollNo);

    Long countAllByDomain(Domain domain);

    Student findFirstByOrderByRollNoDesc();

    Long countAllByEmail(String email);

    @Query("from Student where email = ?1")
    List<Student> findByEmail(String email);
}
