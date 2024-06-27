package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hse.med.recommendation_service.dto.creation.PatientCreationDTO;
import org.hse.med.recommendation_service.model.gmfcs.Gmfcs;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "patient_id")
    private UUID id;

    @Column(name = "patient_full_name", nullable = false)
    private String fullName;

    @Column(name = "patient_gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "patient_date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "patient_age", nullable = false)
    private int age;

    @Column(name = "patient_height", nullable = false)
    private int height;

    @Column(name = "patient_weight", nullable = false)
    private int weight;

    @Column(name = "patient_blood_type")
    private int bloodType;

    @Column(name = "patient_address")
    private String address;

    @Column(name = "patient_contact")
    private String contact;

    @ManyToMany
    @JoinTable (
            name = "patients_diagnoses",
            joinColumns = {@JoinColumn(name = "patient_id")},
            inverseJoinColumns = {@JoinColumn(name = "diagnosis_id")}
    )
    private Set<Diagnosis> diagnoses;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "patient_age_category", referencedColumnName = "age_category"),
            @JoinColumn(name = "gmfcs_level", referencedColumnName = "gmfcs_level")}
    )
    private Gmfcs gmfcs;

    @ManyToOne
    @JoinColumn(name = "recommendation")
    private Recommendation recommendation;

    public Patient(PatientCreationDTO creationDTO) {
        this.fullName = creationDTO.fullName();
        this.gender = creationDTO.gender();
        this.dateOfBirth = creationDTO.dateOfBirth();
        this.age = (int) ChronoUnit.YEARS
                .between(creationDTO.dateOfBirth(), LocalDate.now());
        this.height = creationDTO.height();
        this.weight = creationDTO.weight();
        this.bloodType = creationDTO.bloodType();
        this.address = creationDTO.address();
        this.contact = creationDTO.contact();
        this.diagnoses = creationDTO.diagnoses();
    }
}
