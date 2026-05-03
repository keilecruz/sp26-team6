package com.example.GlowUpAPI.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.GlowUpAPI.entity.Customer;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        Customer customer = (Customer) session.getAttribute("customer");

        if (customer != null) {
            model.addAttribute("userName", customer.getFirstName());
        } else {
            model.addAttribute("userName", "Guest");
        }

        return "dashboard";
    }
}