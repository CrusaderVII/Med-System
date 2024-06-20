package org.hse.med.recommendation_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.creation.DoctorCreationDTO;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.repository.DoctorRepository;
import org.hse.med.recommendation_service.service.DoctorService;
import org.hse.med.recommendation_service.util.exception.doctor.NoSuchDoctorException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    @Override
    public Doctor getById(UUID id) throws NoSuchDoctorException {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchDoctorException("id", id.toString()) );
    }

    @Override
    public Doctor save(DoctorCreationDTO entity) {
        Doctor doctor = new Doctor(entity.fullName(), entity.login(), entity.password());
        return repository.save(doctor);
    }

    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public Doctor update(Doctor entity) {
        return repository.save(entity);
    }
}
