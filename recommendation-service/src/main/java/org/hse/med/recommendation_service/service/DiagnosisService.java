package org.hse.med.recommendation_service.service;

import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.util.exception.diagnosis.NoSuchDiagnosisException;

import java.util.List;
import java.util.Set;

public interface DiagnosisService {

    Diagnosis getById(String code) throws NoSuchDiagnosisException;
    List<Diagnosis> getAll();
}
