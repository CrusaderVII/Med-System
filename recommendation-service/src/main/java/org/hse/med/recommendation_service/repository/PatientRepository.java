package org.hse.med.recommendation_service.repository;

import org.hse.med.recommendation_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {

    @Query("select p from Patient p where p.fullName like ?1")
    List<Patient> findByNamePattern(String namePattern);
}
