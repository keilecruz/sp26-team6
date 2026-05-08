package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.*;
import com.example.GlowUpAPI.service.*;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookingController {

    private final AvailabilityService availabilityService;
    private final ServiceService serviceService;
    private final BookingService bookingService;
    private final BeautyService beautyService;

    public BookingController(AvailabilityService availabilityService,
            ServiceService serviceService,
            BookingService bookingService,
            BeautyService beautyService) {

        this.availabilityService = availabilityService;
        this.serviceService = serviceService;
        this.bookingService = bookingService;
        this.beautyService = beautyService;
    }

    @GetMapping("/{beautyId}")
    public String showBookingPage(@PathVariable Long beautyId, Model model) {

        List<Availability> slots = availabilityService.getByBeautyId(beautyId);
        List<Service> services = serviceService.getByBeautyId(beautyId);

        model.addAttribute("beautyId", beautyId);
        model.addAttribute("slots", slots);
        model.addAttribute("services", services);

        return "customer-booking";
    }

    @PostMapping
    public String createBooking(@RequestParam Long beautyId,
            @RequestParam Long availabilityId,
            @RequestParam Long serviceId,
            @RequestParam String customerName,
            @RequestParam String customerPhone,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        Availability availability = availabilityService.getById(availabilityId);
        Service service = serviceService.getById(serviceId);

        if (availability == null || service == null) {
            return "redirect:/browse";
        }
        Beauty beauty = beautyService.getBeautyById(beautyId).orElse(null);

        if (beauty == null) {
            return "redirect:/browse";
        }

        Booking booking = new Booking();
        booking.setCustomerId(user.getUserId());
        booking.setCustomerName(customerName);
        booking.setCustomerPhone(customerPhone);
        booking.setBeauty(beauty);
        booking.setAvailability(availability);
        booking.setService(service);
        booking.setStatus("PENDING");

        bookingService.save(booking);

        return "redirect:/customer-dashboard";
    }

    @PostMapping("/cancel")
    public String cancelBooking(@RequestParam Long bookingId) {

        bookingService.deleteBooking(bookingId);

        return "redirect:/customer-bookings";
    }
}