package org.hse.med.recommendation_service.service.impl;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.creation.DoctorCreationDTO;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.model.DoctorAuthority;
import org.hse.med.recommendation_service.repository.AuthorityRepository;
import org.hse.med.recommendation_service.repository.DoctorRepository;
import org.hse.med.recommendation_service.service.DoctorService;
import org.hse.med.recommendation_service.util.exception.doctor.NoSuchDoctorException;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final AuthorityRepository authorityRepository;

    @Override
    public Doctor getById(UUID id) throws NoSuchDoctorException {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchDoctorException("id", id.toString()) );
    }

    //TODO: jwt token
    @Override
    public Doctor save(DoctorCreationDTO entity) {
        Doctor doctor = new Doctor(entity.fullName(), entity.login(), entity.password());
        DoctorAuthority authority = authorityRepository.findById(1)
                .get();
        doctor.setAuthorities(Set.of(authority));
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
