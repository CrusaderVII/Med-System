package org.hse.med.recommendation_service.repository;

import org.hse.med.recommendation_service.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, String> {
}
