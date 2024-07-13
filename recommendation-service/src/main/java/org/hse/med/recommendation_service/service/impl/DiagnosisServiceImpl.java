package org.hse.med.recommendation_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.repository.DiagnosisRepository;
import org.hse.med.recommendation_service.service.DiagnosisService;
import org.hse.med.recommendation_service.util.exception.diagnosis.NoSuchDiagnosisException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis getById(String code) throws NoSuchDiagnosisException {
        return diagnosisRepository.findById(code)
                .orElseThrow(()->new NoSuchDiagnosisException("code", code));
    }

    @Override
    public List<Diagnosis> getAll() {
        return diagnosisRepository.findAll();
    }
}
