package com.auca.onlineappaertmentreservistionbook.controller;

import com.auca.onlineappaertmentreservistionbook.model.Administrator;
import com.auca.onlineappaertmentreservistionbook.service.AdministratorService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private AdministratorService administratorService;
    @GetMapping("/adminLogin")
    public String showLoginForm() {
        return "adminLogin";
    }

    @PostMapping("/loginAdmin")
    public String loginAdministrator(@RequestParam String email, @RequestParam String password, Model model, HttpSession session) {
        Administrator loggedInAdministrator = administratorService.loginAdministrator(email, password);
        if (loggedInAdministrator != null) {
            session.setAttribute("loggedInAdministrator", loggedInAdministrator);
            return "redirect:/adminPage"; // Assuming a Thymeleaf template named dashboard.html
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "adminLogin";
        }
    }
}
