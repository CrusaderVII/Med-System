package org.hse.med.recommendation_service.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.creation.DoctorCreationDTO;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.model.DoctorAuthority;
import org.hse.med.recommendation_service.repository.AuthorityRepository;
import org.hse.med.recommendation_service.repository.DoctorRepository;
import org.hse.med.recommendation_service.service.DoctorService;
import org.hse.med.recommendation_service.util.exception.doctor.NoSuchDoctorException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final AuthorityRepository authorityRepository;

    @Override
    public Doctor getById(UUID id) throws NoSuchDoctorException {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new NoSuchDoctorException("id", id.toString()) );
    }

    //TODO: jwt token
    @Override
    @Transactional
    public Doctor save(DoctorCreationDTO entity) {
        Doctor doctor = new Doctor(entity);
        DoctorAuthority authority = authorityRepository.findById(1)
                .get();
        doctor.setAuthorities(Set.of(authority));
        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        doctorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Doctor update(Doctor entity) {
        return doctorRepository.save(entity);
    }
}
