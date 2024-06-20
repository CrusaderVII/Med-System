package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public Doctor(String fullName, String login, String password) {
        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }
}
