package org.hse.med.frontend.dto.creation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class PatientCreationDTO {
    private String fullName;
    private String gender;
    private LocalDate dateOfBirth;
    private int height;
    private int weight;
    private int bloodType;
    private String diagnoses;
    private int GmfcsLevel;
    private String address;
    private String contact;
}
