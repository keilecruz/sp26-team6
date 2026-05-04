package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.service.CustomerService;
import com.example.GlowUpAPI.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private final CustomerService customerService;
    private final UserService userService;

    public SignupController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@RequestParam String email,
                               @RequestParam String password,
                               @RequestParam String role,
                               @RequestParam(required = false) String firstName,
                               @RequestParam(required = false) String lastName,
                               @RequestParam(required = false) String phone,
                               @RequestParam(required = false) String businessName,
                               @RequestParam(required = false) String specialty,
                               HttpSession session) {

        try {
            if ("BEAUTY".equalsIgnoreCase(role) || "PROFESSIONAL".equalsIgnoreCase(role)) {

                if (businessName == null || businessName.isBlank()) {
                    businessName = "New Beauty Professional";
                }

                if (specialty == null || specialty.isBlank()) {
                    specialty = "Beauty Services";
                }

                Beauty beauty = new Beauty();
                beauty.setEmail(email);
                beauty.setPassword(password);
                beauty.setRole(User.Role.BEAUTY);
                beauty.setBusinessName(businessName);
                beauty.setSpecialty(specialty);

                User savedUser = userService.createUser(beauty);

                session.setAttribute("loggedInUserId", savedUser.getUserId());
                session.setAttribute("loggedInRole", savedUser.getRole());
                session.setAttribute("loggedInUser", savedUser);

                return "redirect:/provider-dashboard";
            }

            if (firstName == null || firstName.isBlank()) {
                firstName = "New";
            }

            if (lastName == null || lastName.isBlank()) {
                lastName = "Customer";
            }

            Customer customer = new Customer();
            customer.setEmail(email);
            customer.setPassword(password);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setPhone(phone);
            customer.setRole("CUSTOMER");

            Customer savedCustomer = customerService.createCustomer(customer);

            session.setAttribute("customer", savedCustomer);
            session.setAttribute("loggedInCustomerId", savedCustomer.getId());
            session.setAttribute("loggedInRole", savedCustomer.getRole());

            return "redirect:/dashboard";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error";
        }
    }
}