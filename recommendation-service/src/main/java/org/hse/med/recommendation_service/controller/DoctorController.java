package org.hse.med.recommendation_service.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.RecommendationServiceApplication;
import org.hse.med.recommendation_service.dto.DoctorDTO;
import org.hse.med.recommendation_service.dto.ToDTOMapper;
import org.hse.med.recommendation_service.model.Authority;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.model.DoctorAuthority;
import org.hse.med.recommendation_service.repository.AuthorityRepository;
import org.hse.med.recommendation_service.repository.DoctorRepository;
import org.hse.med.recommendation_service.service.DoctorService;
import org.springframework.boot.SpringApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("med-system/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;
    private final ToDTOMapper mapper;
    private final DoctorRepository doctorRepository;
    private final AuthorityRepository repository;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO getDoctorById(@PathVariable UUID id) {
        Doctor doctor = service.getById(id);
        return mapper.toDoctorDTO(doctor);
    }
}
