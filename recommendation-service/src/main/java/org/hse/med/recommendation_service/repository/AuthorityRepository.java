package org.hse.med.recommendation_service.repository;

import org.hse.med.recommendation_service.model.DoctorAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<DoctorAuthority, Integer> {
}
