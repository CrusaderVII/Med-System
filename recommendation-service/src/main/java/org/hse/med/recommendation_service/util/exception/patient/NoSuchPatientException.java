package org.hse.med.recommendation_service.util.exception.patient;

import org.hse.med.recommendation_service.model.Patient;
import org.hse.med.recommendation_service.util.exception.NoSuchException;

public class NoSuchPatientException extends NoSuchException {
    public NoSuchPatientException(String fieldName, String value) {
        super(Patient.class.getName(), fieldName, value);
    }
}
