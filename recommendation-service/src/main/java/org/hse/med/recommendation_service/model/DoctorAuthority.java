package org.hse.med.recommendation_service.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.swing.plaf.TableHeaderUI;
import java.util.Set;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
public class DoctorAuthority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "authority_name")
    private Authority authority;

    @ManyToMany(mappedBy = "authorities")
    private Set<Doctor> doctors;

    public DoctorAuthority(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority.toString();
    }
}
