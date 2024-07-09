package org.hse.med.frontend.dto;

import java.util.UUID;

public record DoctorDTO(UUID id, String login, String fullName) {
}
