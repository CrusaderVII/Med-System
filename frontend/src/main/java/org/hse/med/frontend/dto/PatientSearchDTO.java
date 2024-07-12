package org.hse.med.frontend.dto;

public class PatientSearchDTO {

    private String name;

    public PatientSearchDTO(String name) {
        this.name = name;
    }

    public PatientSearchDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
