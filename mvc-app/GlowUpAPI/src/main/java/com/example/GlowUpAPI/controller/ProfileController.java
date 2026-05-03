package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.service.CustomerService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    private final CustomerService customerService;

    public ProfileController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // LOAD EDIT PROFILE PAGE

    @GetMapping("/edit-profile")
    public String showEditProfile(HttpSession session, Model model) {

        Customer customer = (Customer) session.getAttribute("customer");

        System.out.println("SESSION CUSTOMER = " + customer);

        if (customer == null) {
            return "redirect:/login";
        }

        model.addAttribute("customer", customer);

        return "editprofile";
    }

    // HANDLE PROFILE UPDATE

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute Customer formCustomer,
            HttpSession session) {

        Customer sessionCustomer = (Customer) session.getAttribute("customer");

        if (sessionCustomer == null) {
            return "redirect:/login";
        }

        Customer dbCustomer = customerService.getCustomerById(sessionCustomer.getId())
                .orElseThrow();

        // FORCE overwrite with form values
        dbCustomer.setFirstName(formCustomer.getFirstName());
        dbCustomer.setLastName(formCustomer.getLastName());
        dbCustomer.setEmail(formCustomer.getEmail());
        dbCustomer.setPassword(formCustomer.getPassword());
        dbCustomer.setPhone(formCustomer.getPhone());
        dbCustomer.setRole(formCustomer.getRole());

        Customer saved = customerService.updateCustomer(dbCustomer.getId(), dbCustomer);

        session.setAttribute("customer", saved);

        return "redirect:/dashboard";
    }
}