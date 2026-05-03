package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.service.CustomerService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    private final CustomerService service;

    public SignupController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerCustomer(@ModelAttribute Customer customer, HttpSession session) {

        try {

            Customer saved = service.createCustomer(customer);

            System.out.println("SAVED ID: " + saved.getId());

            session.setAttribute("customer", saved);

            return "redirect:/dashboard"; //

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error";
        }
    }

}