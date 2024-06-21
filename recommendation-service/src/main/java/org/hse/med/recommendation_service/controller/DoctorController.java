package org.hse.med.recommendation_service.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.dto.DoctorDTO;
import org.hse.med.recommendation_service.dto.ToDTOMapper;
import org.hse.med.recommendation_service.dto.creation.DoctorCreationDTO;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.service.DoctorService;
import org.hse.med.recommendation_service.util.exception.doctor.NoSuchDoctorException;
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
    public DoctorDTO getDoctorById(@PathVariable UUID id) throws NoSuchDoctorException {
        Doctor doctor = service.getById(id);
        return mapper.toDoctorDTO(doctor);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO saveNewDoctor(@RequestBody DoctorCreationDTO creationDTO) {
        Doctor doctor = service.save(creationDTO);
        return mapper.toDoctorDTO(doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDoctor(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
