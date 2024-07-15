package org.hse.med.recommendation_service.controller.advice;

import org.hse.med.recommendation_service.controller.advice.ErrorMessage;
import org.hse.med.recommendation_service.util.exception.diagnosis.NoSuchDiagnosisException;
import org.hse.med.recommendation_service.util.exception.patient.NoSuchPatientException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchDiagnosisException.class)
    public ErrorMessage handleNoSuchDiagnosisException(NoSuchDiagnosisException e) {
        return new ErrorMessage(ExceptionType.NO_SUCH_DIAGNOSIS_EXCEPTION, e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchPatientException.class)
    public ErrorMessage handleNoSuchPatientException(NoSuchPatientException e) {
        return new ErrorMessage(ExceptionType.NO_SUCH_PATIENT_EXCEPTION, e.getMessage());
    }
}
