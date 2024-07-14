package org.hse.med.frontend.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientFullDTO;
import org.hse.med.frontend.dto.PatientSearchDTO;
import org.hse.med.frontend.dto.creation.PatientCreationDTO;
import org.hse.med.frontend.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.UID;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("org.hse/med-system/work")
@RequiredArgsConstructor
public class WorkController {

    private final PatientService patientService;

    @GetMapping
    public String workPage(Model model) {
        model.addAttribute("patientSearchDTO", new PatientSearchDTO());
        return "work.html";
    }

    @PostMapping("/find")
    public String findPatientByName (Model model, @ModelAttribute("patientSearchDTO") PatientSearchDTO patientSearchDTO,
                                     BindingResult bindingResult) {
        List<PatientFullDTO> patients = patientService.findPatientsByName(patientSearchDTO.getName());
        model.addAttribute("patients", patients);
        model.addAttribute("selected_patient", new PatientFullDTO());

        return "found_patients.html";
    }

    @GetMapping("/patient/profile/{id}")
    public String patientProfile(Model model, @PathVariable UUID id) {

        PatientFullDTO patient = patientService.findPatientById(id);
        System.out.println(patient);
        model.addAttribute("patient", patient);
        String firstName = patient.getFullName().split(" ")[1];
        String lastName = patient.getFullName().split(" ")[0];
        model.addAttribute("patient_first_name", firstName);
        model.addAttribute("patient_last_name", lastName);
        return "patient_profile.html";
    }

    @GetMapping("/add")
    public String addPatientPage(Model model) {
        model.addAttribute("patientCreationDTO", new PatientCreationDTO());
        return "add_patient.html";
    }

    @PostMapping("/add")
    public String addNewPatient(Model model, @ModelAttribute("patientCreationDTO") PatientCreationDTO patientCreationDTO,
                                BindingResult bindingResult) {
        PatientFullDTO patient = patientService.addPatient(patientCreationDTO);
        model.addAttribute("patient", patient);

        String firstName = patient.getFullName().split(" ")[1];
        String lastName = patient.getFullName().split(" ")[0];
        model.addAttribute("patient_first_name", firstName);
        model.addAttribute("patient_last_name", lastName);
        return "patient_profile.html";
    }
}
