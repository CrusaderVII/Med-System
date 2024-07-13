package org.hse.med.recommendation_service.dto;

import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.model.Patient;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ToDTOMapper {

    public DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(), doctor.getLogin(), doctor.getFullName());
    }

    public PatientDTO toPatientDTO(Patient patient) {
        Set<DiagnosisDTO> diagnosisDTOs = patient.getDiagnoses()
                .stream()
                .map(this::toDiagnosisDTO)
                .collect(Collectors.toSet());

        return new PatientDTO(patient.getId(), patient.getFullName(), patient.getGender(), patient.getDateOfBirth(),
                              patient.getHeight(), patient.getWeight(), patient.getBloodType(), patient.getAddress(),
                              patient.getContact(), diagnosisDTOs);
    }

    public DiagnosisDTO toDiagnosisDTO(Diagnosis diagnosis) {
        return new DiagnosisDTO(diagnosis.getCode(), diagnosis.getName());
    }
}
