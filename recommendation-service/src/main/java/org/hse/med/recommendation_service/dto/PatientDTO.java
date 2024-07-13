package org.hse.med.recommendation_service.dto;

import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.model.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public record PatientDTO(UUID id, String fullName, Gender gender, LocalDate dateOfBirth, int height,
                         int weight, int bloodType, String address, String contact, Set<DiagnosisDTO> diagnoses) {
}
