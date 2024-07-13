package org.hse.med.recommendation_service.controller;

import lombok.RequiredArgsConstructor;
import org.hse.med.recommendation_service.model.Diagnosis;
import org.hse.med.recommendation_service.service.DiagnosisService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("med-system/api/v1/diagnosis")
@RequiredArgsConstructor
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Diagnosis> getAllDiagnosis() {
        return diagnosisService.getAll();
    }
}
