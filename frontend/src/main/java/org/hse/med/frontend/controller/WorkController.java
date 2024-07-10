package org.hse.med.frontend.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientSearchDTO;
import org.hse.med.frontend.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

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
        List<PatientDTO> patients = patientService.findPatientsByName("");
        model.addAttribute("patients", patients);

        return "found_patients.html";
    }
}
