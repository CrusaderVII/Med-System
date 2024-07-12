package org.hse.med.frontend.service.impl;

import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;
import org.hse.med.frontend.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public List<PatientDTO> findPatientsByName(String name) {
        PatientDTO patientDTO = new PatientDTO("Ivanov Ivan Ivanovich", LocalDate.now(), 19);
        List<PatientDTO> patients = List.of(patientDTO);
        return patients;
    }

    @Override
    public PatientDTO addPatient(PatientCreationDTO patientCreationDTO) {
        System.out.println(patientCreationDTO);
        int age = (int) ChronoUnit.YEARS.between(LocalDate.now(), patientCreationDTO.getDateOfBirth());
        PatientDTO patientDTO = new PatientDTO(patientCreationDTO.getFullName(), patientCreationDTO.getDateOfBirth(),
                age);
        System.out.println(patientDTO);
        return null;
    }
}
