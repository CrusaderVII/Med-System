package org.hse.med.recommendation_service.dto;

import java.util.UUID;

public record DoctorDTO(UUID id, String login, String fullName) {
}
