package org.hse.med.frontend.service;

import org.hse.med.frontend.dto.DiagnosisDTO;

import java.util.List;

public interface DiagnosisService {
    List<DiagnosisDTO> findAllDiagnoses();
}
