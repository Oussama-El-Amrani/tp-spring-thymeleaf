package io.oussamaib0.tpspringthymeleaf.repository;

import io.oussamaib0.tpspringthymeleaf.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Page<Patient> findByNameContainsIgnoreCase(String keyword, Pageable pageable);
}
