package com.example.GlowUpAPI.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.GlowUpAPI.entity.Booking;
import com.example.GlowUpAPI.entity.Customer;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.service.BookingService;
import com.example.GlowUpAPI.service.CustomerService;
import com.example.GlowUpAPI.service.UserService;

import java.util.List;
import java.util.Collections;

@Controller
public class DashboardController {

    private final CustomerService customerService;
    private final UserService userService;
    private final BookingService bookingService;

    public DashboardController(UserService userService,
            CustomerService customerService,
            BookingService bookingService) {

        this.userService = userService;
        this.customerService = customerService;
        this.bookingService = bookingService;
    }

    @GetMapping("/customer-dashboard")
    public String customerDashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        if (user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/provider-dashboard";
        }

        Customer customer = customerService
                .getCustomerById(user.getUserId())
                .orElse(null);

        String name = (customer != null) ? customer.getFirstName() : "User";
        model.addAttribute("userName", name);

        List<Booking> bookings = bookingService.getByCustomerId(user.getUserId());
        model.addAttribute("bookings", bookings);

        List<User> providers = userService.getAllProviders();
        Collections.shuffle(providers);

        if (providers.size() > 3) {
            providers = providers.subList(0, 3);
        }

        model.addAttribute("providers", providers);

        return "customer-dashboard";
    }

}