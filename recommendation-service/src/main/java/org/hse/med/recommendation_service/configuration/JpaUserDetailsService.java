package org.hse.med.recommendation_service.configuration;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.model.Doctor;
import org.hse.med.recommendation_service.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.print.Doc;


@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private DoctorRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("No user with name: "+username));

        DoctorSecurityDecorator doctorDetails = new DoctorSecurityDecorator(doctor);
        return doctorDetails;
    }
}
