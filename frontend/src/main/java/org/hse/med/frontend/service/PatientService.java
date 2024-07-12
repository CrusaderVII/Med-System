package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.PatientDTO;

import java.util.List;

public interface PatientService {
    List<PatientDTO> findPatientsByName(String name);
}
