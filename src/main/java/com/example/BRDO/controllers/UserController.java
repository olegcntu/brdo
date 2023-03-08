package com.example.BRDO.controllers;

import com.example.BRDO.models.User;
import com.example.BRDO.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServices userServices;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userServices.getUsersOrLoad();

        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/reload")
    public String reloadUsers(Model model) {
        List<User> users = userServices.reloadAndGetUsers();

        model.addAttribute("users", users);
        return "users";
    }
}
