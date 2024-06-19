package org.hse.med.recommendation_service.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.DoctorDTO;
import org.hse.med.recommendation_service.dto.ToDTOMapper;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("med-system/api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService service;
    private final ToDTOMapper mapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO getDoctorById(@PathVariable UUID id) {
        Doctor doctor = service.getById(id);
        return mapper.toDoctorDTO(doctor);
    }
}
