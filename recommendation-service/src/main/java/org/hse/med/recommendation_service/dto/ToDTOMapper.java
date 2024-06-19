package org.hse.med.recommendation_service.dto;

import org.hse.med.recommendation_service.model.Doctor;
import org.springframework.stereotype.Service;

@Service
public class ToDTOMapper {

    public DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(), doctor.getLogin(), doctor.getFullName());
    }
}
