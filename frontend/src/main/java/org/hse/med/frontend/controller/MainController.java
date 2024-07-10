package org.hse.med.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/work")
    public String workPage() {
        return "work.html";
    }

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
