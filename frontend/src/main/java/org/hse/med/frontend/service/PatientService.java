package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> findPatientsByName(String name);
    PatientDTO addPatient(PatientCreationDTO patientCreationDTO);
}
