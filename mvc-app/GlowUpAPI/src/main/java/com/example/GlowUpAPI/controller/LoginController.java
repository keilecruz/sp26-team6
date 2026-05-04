package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.service.CustomerService;
import com.example.GlowUpAPI.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginController {

    private final CustomerService customerService;
    private final UserService userService;

    public LoginController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        Optional<User> userOptional = userService.getUserByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            if (!user.getPassword().equals(password)) {
                return "redirect:/login?error";
            }

            session.setAttribute("loggedInUserId", user.getUserId());
            session.setAttribute("loggedInRole", user.getRole());
            session.setAttribute("loggedInUser", user);

            if (user.getRole() == User.Role.BEAUTY) {
                return "redirect:/provider-dashboard";
            }

            if (user.getRole() == User.Role.ADMIN) {
                return "redirect:/admin/dashboard";
            }

            return "redirect:/dashboard";
        }

        Customer customer = customerService.getCustomerByEmail(email)
                .orElse(null);

        if (customer == null || !customer.getPassword().equals(password)) {
            return "redirect:/login?error";
        }

        session.setAttribute("customer", customer);
        session.setAttribute("loggedInCustomerId", customer.getId());
        session.setAttribute("loggedInRole", customer.getRole());

        if ("ADMIN".equalsIgnoreCase(customer.getRole())) {
            return "redirect:/admin/dashboard";
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}