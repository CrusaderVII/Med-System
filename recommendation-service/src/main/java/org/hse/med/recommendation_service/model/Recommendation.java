package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hse.med.recommendation_service.model.gmfcs.Gmfcs;

import java.util.Set;

@Entity
@Table(name = "recommendations")
@Getter
@Setter
@NoArgsConstructor
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommendation_id")
    private long id;

    @Column(name = "recommendation_value")
    private String recommendation;

    @Column(name = "recommendation_contradictions")
    private String contradictions;

    @ManyToMany
    @JoinTable (
        name = "diagnoses_recommendations",
        joinColumns = {@JoinColumn(name = "recommendation_id")},
        inverseJoinColumns = {@JoinColumn(name = "diagnosis_id")}
    )
    private Set<Diagnosis> diagnoses;

    @OneToMany
    private Set<Gmfcs> gmfcs;

    @OneToMany
    private Set<Patient> patients;

    public Recommendation(String recommendation, String contradictions) {
        this.recommendation = recommendation;
        this.contradictions = contradictions;
    }
}
