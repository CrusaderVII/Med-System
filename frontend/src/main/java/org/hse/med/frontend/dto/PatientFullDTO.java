package org.hse.med.frontend.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@ToString
public class PatientFullDTO {
    private UUID id;
    private String fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private int height;
    private int weight;
    private int bloodType;
    private String address;
    private String contact;
    private Set<DiagnosisDTO> diagnoses;
}
