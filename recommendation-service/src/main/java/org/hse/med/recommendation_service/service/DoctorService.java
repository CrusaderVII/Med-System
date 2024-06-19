package org.hse.med.recommendation_service.service;

import org.hse.med.recommendation_service.model.Doctor;

import java.util.UUID;

public interface DoctorService {
    public Doctor getById(UUID id);
}
