package org.hse.med.recommendation_service.util.exception.doctor;

import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.util.exception.NoSuchException;

public class NoSuchDoctorException extends NoSuchException {
    public NoSuchDoctorException(String fieldName, String value) {
        super(Doctor.class.getName(), fieldName, value);
    }
}
