package org.hse.med.recommendation_service.repository;

import org.hse.med.recommendation_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

    public Optional<Doctor> findByLogin(String login);
}
