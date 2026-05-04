package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.entity.Portfolio;
import com.example.GlowUpAPI.service.CustomerService;
import com.example.GlowUpAPI.service.PortfolioService;
import com.example.GlowUpAPI.service.UserService;
import com.example.GlowUpAPI.entity.User;
import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @Autowired
    private PortfolioService portfolioService;
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final UserService userService;

    public ProfileController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/edit-profile")
    public String showEditProfile(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        Customer customer = customerService
                .getCustomerById(user.getUserId())
                .orElseThrow();

        model.addAttribute("customer", customer);

        return "customer-editprofile";
    }

    @PostMapping("/edit-profile")
    public String updateProfile(@ModelAttribute Customer formCustomer,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        Customer dbCustomer = customerService
                .getCustomerById(user.getUserId())
                .orElseThrow();

        dbCustomer.setFirstName(formCustomer.getFirstName());
        dbCustomer.setLastName(formCustomer.getLastName());
        dbCustomer.setEmail(formCustomer.getEmail());
        dbCustomer.setPassword(formCustomer.getPassword());
        dbCustomer.setPhone(formCustomer.getPhone());

        customerService.updateCustomer(dbCustomer.getId(), dbCustomer);

        return "redirect:/customer-dashboard";
    }

 @GetMapping("/provider/{id}")
public String viewProvider(@PathVariable Long id,
                           HttpSession session,
                           Model model) {

    User user = userService.getUserById(id)
            .orElseThrow();

    if (!(user instanceof Beauty)) {
        return "redirect:/browse";
    }

    Beauty beauty = (Beauty) user;
    model.addAttribute("beauty", beauty);

    // 🔥 Logged-in user
    User loggedIn = (User) session.getAttribute("loggedInUser");

    // ✅ role
    String roleString = "";
    if (loggedIn != null && loggedIn.getRole() != null) {
        roleString = loggedIn.getRole().name();
    }
    model.addAttribute("roleString", roleString);

    // ✅ FIXED ownership logic
    boolean isOwner = false;

    if (loggedIn != null
            && loggedIn.getRole() == User.Role.BEAUTY   // 🔥 critical fix
            && loggedIn.getUserId() != null
            && id != null) {

        isOwner = loggedIn.getUserId().longValue() == id.longValue();
    }

    model.addAttribute("isOwner", isOwner);

    // 🔥 LOAD REAL DATA (portfolio images)
    List<Portfolio> portfolios = portfolioService.getPortfoliosByBeautyId(id);
    model.addAttribute("portfolios", portfolios);

    // (you can upgrade these later)
    model.addAttribute("reviews", java.util.Collections.emptyList());
    model.addAttribute("reviewCount", 0);
    model.addAttribute("averageRating", 0.0);

    return "provider-profile";
}
}