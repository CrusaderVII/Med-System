package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;

import java.util.List;

public interface CommunicationService {
    PatientFullDTO addPatient(PatientCreationDTO patientCreationDTO);
    List<PatientFullDTO> getPatientsWithPathVar(String pathVariable, String field);
}
