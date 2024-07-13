package org.hse.med.recommendation_service.service;

import org.hse.med.recommendation_service.dto.creation.PatientCreationDTO;
import org.hse.med.recommendation_service.model.Patient;
import org.hse.med.recommendation_service.util.exception.diagnosis.NoSuchDiagnosisException;
import org.hse.med.recommendation_service.util.exception.patient.NoSuchPatientException;
import org.springframework.security.core.parameters.P;

import java.util.UUID;

public interface PatientService {

    Patient getById (UUID id) throws NoSuchPatientException;
    Patient save(PatientCreationDTO entity) throws NoSuchDiagnosisException;
    Patient update(Patient entity);
    void deleteById(UUID id);

}
