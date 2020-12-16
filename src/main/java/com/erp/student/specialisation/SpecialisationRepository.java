package com.erp.student.specialisation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationRepository extends JpaRepository<Specialisation, Long> {
    Specialisation findByCode(Long code);
}
