package org.hse.med.frontend.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;
import org.hse.med.frontend.service.CommunicationService;
import org.hse.med.frontend.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final CommunicationService communicationService;

    @Override
    public List<PatientFullDTO> findPatientsByName(String name) {
        name = name.replaceAll(" ", "+");
        if (name==null || name.equals("")) name = "-";
        List<PatientFullDTO> patients = communicationService.getPatientsWithNamePattern(name);
        return patients;
    }

    @Override
    public PatientFullDTO findPatientById(UUID id) {
        PatientFullDTO patient = communicationService.getPatientWithId(id);
        return patient;
    }

    @Override
    public PatientFullDTO addPatient(PatientCreationDTO patientCreationDTO) {
        patientCreationDTO.setGender(patientCreationDTO.getGender().toUpperCase());
        System.out.println(patientCreationDTO);
        PatientFullDTO patientDTO = communicationService.addPatient(patientCreationDTO);
        System.out.println(patientDTO);
        return patientDTO;
    }
}
