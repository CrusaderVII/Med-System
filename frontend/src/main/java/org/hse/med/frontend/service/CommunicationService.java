package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;

public interface CommunicationService {
    PatientFullDTO addPatient(PatientCreationDTO patientCreationDTO);
}
