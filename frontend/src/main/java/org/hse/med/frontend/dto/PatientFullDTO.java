package org.hse.med.frontend.dto;

import java.time.LocalDate;
import java.util.UUID;

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
}
