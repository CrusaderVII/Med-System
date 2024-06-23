package org.hse.med.recommendation_service.dto;

import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.model.Patient;
import org.springframework.stereotype.Service;

@Service
public class ToDTOMapper {

    public DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(), doctor.getLogin(), doctor.getFullName());
    }

    public PatientDTO toPatientDTO(Patient patient) {
        return new PatientDTO(patient.getId(), patient.getFullName(), patient.getGender(), patient.getDateOfBirth(),
                              patient.getHeight(), patient.getWeight(), patient.getBloodType(), patient.getAddress(),
                              patient.getContact());
    }
}
