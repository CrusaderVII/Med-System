package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.DiagnosisDTO;
import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;

import java.util.List;
import java.util.UUID;

public interface CommunicationService {
    PatientFullDTO addPatient(PatientCreationDTO patientCreationDTO);
    List<PatientFullDTO> getPatientsWithNamePattern(String pattern);
    PatientFullDTO getPatientWithId(UUID id);
    List<DiagnosisDTO> getAllDiagnoses();
}
