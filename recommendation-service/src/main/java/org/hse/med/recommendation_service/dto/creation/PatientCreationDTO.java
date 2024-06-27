package org.hse.med.recommendation_service.dto.creation;

import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.model.Gender;

import java.time.LocalDate;
import java.util.Set;

public record PatientCreationDTO(String fullName, Gender gender, LocalDate dateOfBirth, int height, int weight,
                                 int bloodType, String address, String contact, Set<Diagnosis> diagnoses) {
}
