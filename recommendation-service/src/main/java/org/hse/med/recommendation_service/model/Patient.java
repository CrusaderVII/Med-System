package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hse.med.recommendation_service.model.gmfcs.Gmfcs;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "patient_full_name", nullable = false)
    private String fullName;

    @Column(name = "patient_gender", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "patient_date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "patient_age_category")
    private int ageCategory;

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
    @JoinColumn(name = "gmfcs")
    private Gmfcs gmfcs;
}
