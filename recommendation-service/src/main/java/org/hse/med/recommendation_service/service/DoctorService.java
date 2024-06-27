package org.hse.med.recommendation_service.service;

import org.hse.med.recommendation_service.dto.creation.DoctorCreationDTO;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.util.exception.doctor.NoSuchDoctorException;

import java.util.UUID;

public interface DoctorService {
    public Doctor getById(UUID id) throws NoSuchDoctorException;
    public Doctor save(DoctorCreationDTO entity);
    public void deleteById(UUID id);
    public Doctor update(Doctor entity);
}
