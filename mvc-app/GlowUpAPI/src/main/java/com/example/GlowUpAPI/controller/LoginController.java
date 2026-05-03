package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final CustomerService customerService;

    public LoginController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
            @RequestParam String password,
            HttpSession session) {

        Customer customer = customerService.getCustomerByEmail(email)
                .orElse(null);

        if (customer == null || !customer.getPassword().equals(password)) {
            return "redirect:/login?error";
        }

        session.setAttribute("customer", customer);

        // basing on role-base direct
        if ("ADMIN".equals(customer.getRole())) {
            return "redirect:/admin/dashboard";
        } else if ("PROFESSIONAL".equals(customer.getRole())) {
            return "redirect:/professional/dashboard";
        } else {
            return "redirect:/dashboard"; // CUSTOMER
        }
    }
}