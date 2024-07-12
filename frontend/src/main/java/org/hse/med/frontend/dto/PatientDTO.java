package org.hse.med.frontend.dto;

import java.time.LocalDate;

public record PatientDTO(String name, LocalDate dateOfBirth, int age) {
}
