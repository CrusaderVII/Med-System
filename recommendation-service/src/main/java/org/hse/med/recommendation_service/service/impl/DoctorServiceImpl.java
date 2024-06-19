package org.hse.med.recommendation_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.repository.DoctorRepository;
import org.hse.med.recommendation_service.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    @Override
    public Doctor getById(UUID id) throws RuntimeException{
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No doctor with such id"));
    }
}
