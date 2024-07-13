package org.hse.med.recommendation_service.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.PatientDTO;
import org.hse.med.recommendation_service.dto.ToDTOMapper;
import org.hse.med.recommendation_service.dto.creation.PatientCreationDTO;
import org.hse.med.recommendation_service.model.Patient;
import org.hse.med.recommendation_service.service.PatientService;
import org.hse.med.recommendation_service.util.exception.diagnosis.NoSuchDiagnosisException;
import org.hse.med.recommendation_service.util.exception.patient.NoSuchPatientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("med-system/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final ToDTOMapper mapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PatientDTO getPatientById(@PathVariable UUID id) throws NoSuchPatientException {
        Patient patient = patientService.getById(id);
        return mapper.toPatientDTO(patient);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public PatientDTO saveNewPatient(@RequestBody PatientCreationDTO patientCreationDTO) throws NoSuchDiagnosisException {
        Patient patient = patientService.save(patientCreationDTO);
        return mapper.toPatientDTO(patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePatient(@PathVariable UUID id) {
        patientService.deleteById(id);
    }
}
