package org.hse.med.frontend.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;
import org.hse.med.frontend.factory.RestTemplateFactory;
import org.hse.med.frontend.service.CommunicationService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
}
