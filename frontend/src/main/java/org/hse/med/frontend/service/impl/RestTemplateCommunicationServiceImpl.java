package org.hse.med.frontend.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.dto.DiagnosisDTO;
import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;
import org.hse.med.frontend.factory.RestTemplateFactory;
import org.hse.med.frontend.service.CommunicationService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RestTemplateCommunicationServiceImpl implements CommunicationService {

    private final RestTemplateFactory factory;

    @Override
    public PatientFullDTO addPatient(PatientCreationDTO patientCreationDTO) {
        RestTemplate rest = factory.getObject();
        PatientFullDTO patientFullDTO = rest.postForObject("http://localhost:8080/med-system/api/v1/patient/save",
                patientCreationDTO,
                PatientFullDTO.class);

        return patientFullDTO;
    }

    @Override
    public List<PatientFullDTO> getPatientsWithNamePattern(String pattern) {
        RestTemplate rest = factory.getObject();
        String url = "http://localhost:8080/med-system/api/v1/patient/name/"+pattern;
        List<PatientFullDTO> patientFullDTOs = new ArrayList<>();

        patientFullDTOs = rest.getForObject(url, patientFullDTOs.getClass());

        return patientFullDTOs;
    }

    @Override
    public PatientFullDTO getPatientWithId(UUID id) {
        RestTemplate rest = factory.getObject();
        String url = "http://localhost:8080/med-system/api/v1/patient/id/"+id;

        PatientFullDTO patientFullDTO = rest.getForObject(url, PatientFullDTO.class);

        return patientFullDTO;
    }

    @Override
    public List<DiagnosisDTO> getAllDiagnoses() {
        RestTemplate rest = factory.getObject();
        String url = "http://localhost:8080/med-system/api/v1/diagnosis/all";
        List<DiagnosisDTO> diagnoses = new ArrayList<>();

        diagnoses = rest.getForObject(url, diagnoses.getClass());

        return diagnoses;
    }
}
