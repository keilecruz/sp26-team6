package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AuthViewController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPageAgain() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password, HttpSession session, Model model) {
        Optional<User> userOptional = userService.login(email, password);

        if (userOptional.isEmpty()) {
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }

        User user = userOptional.get();

        session.setAttribute("loggedInUserId", user.getUserId());
        session.setAttribute("loggedInRole", user.getRole());

        if (user.getRole() == User.Role.BEAUTY) {
            return "redirect:/provider-dashboard";
        } else if (user.getRole() == User.Role.CUSTOMER) {
            return "redirect:/customer-dashboard";
        } else {
            return "redirect:/admin-dashboard";
        }
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(String email,
                         String password,
                         String role,
                         String businessName,
                         String specialty,
                         HttpSession session) {

        if (role.equals("BEAUTY")) {
            Beauty beauty = new Beauty();
            beauty.setEmail(email);
            beauty.setPassword(password);
            beauty.setRole(User.Role.BEAUTY);
            beauty.setBusinessName(businessName);
            beauty.setSpecialty(specialty);

            User savedUser = userService.createUser(beauty);

            session.setAttribute("loggedInUserId", savedUser.getUserId());
            session.setAttribute("loggedInRole", savedUser.getRole());

            return "redirect:/provider-dashboard";
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(User.Role.CUSTOMER);

        User savedUser = userService.createUser(user);

        session.setAttribute("loggedInUserId", savedUser.getUserId());
        session.setAttribute("loggedInRole", savedUser.getRole());

        return "redirect:/customer-dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}