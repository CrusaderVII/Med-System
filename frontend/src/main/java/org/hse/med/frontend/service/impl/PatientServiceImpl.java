package org.hse.med.frontend.service.impl;

import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.service.PatientService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Override
    public List<PatientDTO> findPatientsByName(String name) {
        PatientDTO patientDTO = new PatientDTO("Ivanov Ivan Ivanovich", LocalDate.now(), 19);
        List<PatientDTO> patients = List.of(patientDTO);
        return patients;
    }
}
