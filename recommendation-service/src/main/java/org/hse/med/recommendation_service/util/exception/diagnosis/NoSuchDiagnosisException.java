package org.hse.med.recommendation_service.util.exception.diagnosis;

import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.util.exception.NoSuchException;

public class NoSuchDiagnosisException extends NoSuchException {

    public NoSuchDiagnosisException(String fieldName, String value) {
        super(Diagnosis.class.getName(), fieldName, value);
    }
}
