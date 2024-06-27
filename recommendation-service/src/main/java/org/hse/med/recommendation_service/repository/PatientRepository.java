package org.hse.med.recommendation_service.repository;

import org.hse.med.recommendation_service.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
