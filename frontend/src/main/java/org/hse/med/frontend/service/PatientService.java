package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    PatientFullDTO findPatientById(UUID id);
    List<PatientFullDTO> findPatientsByName(String name);
    PatientFullDTO addPatient(PatientCreationDTO patientCreationDTO);
}
