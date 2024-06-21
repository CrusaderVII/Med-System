package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "diagnoses")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Diagnosis {

    @Id
    @Column(name = "diagnosis_id")
    private String code;

    @Column(name = "diagnosis_name")
    private String name;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Patient> patients;

}
