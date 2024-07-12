package org.hse.med.frontend.controller;

import org.hse.med.frontend.dto.PatientDTO;
import org.hse.med.frontend.dto.PatientSearchDTO;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("org.hse/med-system")
public class MainController {

    @GetMapping("/login")
    public String loginPage() {
        return "login.html";
    }

//    @PostMapping("/login")
//    public String login() {
//
//    }

    @GetMapping("/home")
    public String homePage() {
        return "home.html";
    }

    @GetMapping("/help")
    public String helpPage() {
        return "help.html";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "contact.html";
    }
}
