package com.example.BRDO.controllers.security_controllers;

import com.example.BRDO.models.security_model.Admin;
import com.example.BRDO.services.security.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "security/login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "security/registration";
    }


    @PostMapping("/registration")
    public String createAdmin(Admin admin) {
        if (!adminService.createAdmin(admin)) {
            return "security/registration";
        }
        return "redirect:/login";
    }

}
