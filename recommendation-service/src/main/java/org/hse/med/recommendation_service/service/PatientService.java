package org.hse.med.recommendation_service.service;

import org.hse.med.recommendation_service.dto.creation.PatientCreationDTO;
import org.hse.med.recommendation_service.model.Patient;
import org.springframework.security.core.parameters.P;

import java.util.UUID;

public interface PatientService {

    Patient getById (UUID id);
    Patient save(PatientCreationDTO entity);
}
