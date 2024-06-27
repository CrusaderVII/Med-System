package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hse.med.recommendation_service.dto.creation.DoctorCreationDTO;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "doctors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "doctor_id")
    private UUID id;

    @Column(name = "doctor_full_name")
    private String fullName;

    @Column(name = "doctor_login")
    private String login;

    @Column(name = "doctor_password")
    private String password;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable (
            name = "doctors_authorities",
            joinColumns = {@JoinColumn(name = "doctor_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")}
    )
    private Set<DoctorAuthority> authorities;

    public Doctor(String fullName, String login, String password) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }

    public Doctor(DoctorCreationDTO doctorCreationDTO) {
        this.fullName = doctorCreationDTO.fullName();
        this.login = doctorCreationDTO.login();
        this.password = doctorCreationDTO.password();
    }
}
