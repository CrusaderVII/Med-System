package org.hse.med.frontend.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.dto.DiagnosisDTO;
import org.hse.med.frontend.service.CommunicationService;
import org.hse.med.frontend.service.DiagnosisService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final CommunicationService communicationService;
    @Override
    public List<DiagnosisDTO> findAllDiagnoses() {
        List<DiagnosisDTO> diagnoses = communicationService.getAllDiagnoses();
        return diagnoses;
    }
}
