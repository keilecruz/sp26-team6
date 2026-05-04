package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Booking;
import com.example.GlowUpAPI.entity.Review;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.service.BookingService;
import com.example.GlowUpAPI.service.ReviewService;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerPageController {

    private final BookingService bookingService;
    private final ReviewService reviewService;

    public CustomerPageController(BookingService bookingService,
                                  ReviewService reviewService) {
        this.bookingService = bookingService;
        this.reviewService = reviewService;
    }

    @GetMapping("/customer-bookings")
    public String customerBookings(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        List<Booking> bookings = bookingService.getByCustomerId(user.getUserId());
        model.addAttribute("bookings", bookings);

        return "customer-bookingsview";
    }

    @GetMapping("/customer-reviews")
    public String customerReviews(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        List<Review> reviews = reviewService.getReviewsByCustomerId(user.getUserId());
        model.addAttribute("reviews", reviews);

        return "customer-reviews";
    }
}