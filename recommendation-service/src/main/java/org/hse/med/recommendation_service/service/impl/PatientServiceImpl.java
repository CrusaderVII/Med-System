package org.hse.med.recommendation_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.creation.PatientCreationDTO;
import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.model.Patient;
import org.hse.med.recommendation_service.repository.PatientRepository;
import org.hse.med.recommendation_service.service.DiagnosisService;
import org.hse.med.recommendation_service.service.PatientService;
import org.hse.med.recommendation_service.util.exception.diagnosis.NoSuchDiagnosisException;
import org.hse.med.recommendation_service.util.exception.patient.NoSuchPatientException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final DiagnosisService diagnosisService;

    @Override
    public Patient getById(UUID id) throws NoSuchPatientException {
        return patientRepository.findById(id)
                .orElseThrow(() -> new NoSuchPatientException("id", id.toString()));
    }

    @Override
    public List<Patient> getByName(String namePattern) {
        String validNamePattern = namePattern.replaceAll("\\+", " ")+"%";
        return patientRepository.findByNamePattern(validNamePattern);
    }

    @Override
    public Patient save(PatientCreationDTO entity) throws NoSuchDiagnosisException {
        Patient patient = new Patient(entity);
        patient.setDiagnoses(mapDiagnoses(entity.diagnoses()));
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

    private Set<Diagnosis> mapDiagnoses(String diagnoses) throws NoSuchDiagnosisException{
        Set<Diagnosis> mappedDiagnoses = new HashSet<>();

        for (String code : diagnoses.split(" ")) {
            mappedDiagnoses.add(diagnosisService.getById(code));
        }

        return mappedDiagnoses;
    }
}
