package org.hse.med.recommendation_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.creation.PatientCreationDTO;
import org.hse.med.recommendation_service.model.Gender;
import org.hse.med.recommendation_service.model.Patient;
import org.hse.med.recommendation_service.repository.PatientRepository;
import org.hse.med.recommendation_service.service.PatientService;
import org.hse.med.recommendation_service.util.exception.patient.NoSuchPatientException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient getById(UUID id) throws NoSuchPatientException {
        return patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchPatientException("id", id.toString()));
    }

    @Override
    public Patient save(PatientCreationDTO entity) {
        Patient patient = new Patient(entity);
        return patientRepository.save(patient);
    }

    @Override
    public Patient update(Patient entity) {
        return patientRepository.save(entity);
    }

    @Override
    public void deleteById(UUID id) {
        patientRepository.deleteById(id);
    }
}
