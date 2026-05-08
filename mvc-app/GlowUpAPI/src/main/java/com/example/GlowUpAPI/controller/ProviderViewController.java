package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Availability;
import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.Portfolio;
import com.example.GlowUpAPI.entity.Review;
import com.example.GlowUpAPI.entity.Service;
import com.example.GlowUpAPI.service.AvailabilityService;
import com.example.GlowUpAPI.service.BeautyService;
import com.example.GlowUpAPI.service.PortfolioService;
import com.example.GlowUpAPI.service.ReviewService;
import com.example.GlowUpAPI.service.ServiceService;
import com.example.GlowUpAPI.service.UserService;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.entity.Booking;
import com.example.GlowUpAPI.service.BookingService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProviderViewController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private AvailabilityService availabilityService;

    @Autowired
    private BeautyService beautyService;

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private BookingService bookingService;

    private Long getLoggedInBeautyId(HttpSession session) {
        Object userId = session.getAttribute("loggedInUserId");

        if (userId == null) {
            return null;
        }

        return (Long) userId;
    }

    private double calculateAverageRating(List<Review> reviews) {
        if (reviews == null || reviews.isEmpty()) {
            return 0.0;
        }

        return reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);
    }

    @GetMapping("/provider-dashboard")
    public String providerDashboard(HttpSession session, Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        // 🔒 ensure only providers
        if (user.getRole() != User.Role.BEAUTY) {
            return "redirect:/customer-dashboard";
        }

        model.addAttribute("userName", user.getEmail());

        return "provider-dashboard";
    }

    @GetMapping("/provider-profile")
    public String showProviderProfile(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        List<Portfolio> portfolios = portfolioService.getPortfoliosByBeautyId(beautyId);
        List<Review> reviews = reviewService.getReviewsByBeautyId(beautyId);

        double averageRating = calculateAverageRating(reviews);

        model.addAttribute("beauty", beauty);
        model.addAttribute("portfolios", portfolios);
        model.addAttribute("reviews", reviews);
        model.addAttribute("averageRating", averageRating);
        model.addAttribute("reviewCount", reviews.size());

        model.addAttribute("roleString", "BEAUTY");
        model.addAttribute("isOwner", true);

        return "provider-profile";
    }

    @GetMapping("/provider-profile/edit")
    public String showEditProviderProfile(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        List<Portfolio> portfolios = portfolioService.getPortfoliosByBeautyId(beautyId);

        model.addAttribute("beauty", beauty);
        model.addAttribute("portfolios", portfolios);

        return "provider-profile-edit";
    }

    @PostMapping("/provider-profile/update")
    public String updateProviderProfile(Beauty updatedBeauty, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        beautyService.updateBeauty(beautyId, updatedBeauty);

        return "redirect:/provider-profile";
    }

    @PostMapping("/provider-sample-work/add")
    public String addSampleWork(String imageUrl, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        if (imageUrl == null || imageUrl.isBlank()) {
            return "redirect:/provider-profile/edit";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        Portfolio portfolio = new Portfolio();
        portfolio.setImageUrl(imageUrl);
        portfolio.setBeauty(beauty);

        portfolioService.createPortfolio(portfolio);

        return "redirect:/provider-profile/edit";
    }

    @GetMapping("/provider-sample-work/delete/{id}")
    public String deleteSampleWork(@PathVariable Long id, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        if (portfolioService.belongsToBeauty(id, beautyId)) {
            portfolioService.deletePortfolio(id);
        }

        return "redirect:/provider-profile/edit";
    }

    @GetMapping("/provider-bookings")
    public String showProviderBookings(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        List<Booking> bookings = bookingService.getByBeautyId(beautyId);
        model.addAttribute("bookings", bookings);

        return "provider-bookings";
    }


    
    @GetMapping("/provider-reviews")
    public String showProviderReviews(@RequestParam(required = false) Long beautyId,
                                  Model model,
                                  HttpSession session) {

        if (beautyId == null) {
            beautyId = getLoggedInBeautyId(session);
        }

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId)
            .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        List<Review> reviews = reviewService.getReviewsByBeautyId(beautyId);
        double averageRating = calculateAverageRating(reviews);
        Object role = session.getAttribute("loggedInRole");

        model.addAttribute("beauty", beauty);
        model.addAttribute("reviews", reviews);
        model.addAttribute("averageRating", averageRating);
        model.addAttribute("reviewCount", reviews.size());
        model.addAttribute("roleString", role != null ? role.toString() : "CUSTOMER");

        return "provider-reviews";
    }

    @GetMapping("/provider/{beautyId}/reviews")
    public String showPublicProviderReviews(@PathVariable Long beautyId, Model model, HttpSession session) {
        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        List<Review> reviews = reviewService.getReviewsByBeautyId(beautyId);
        double averageRating = calculateAverageRating(reviews);
        Object role = session.getAttribute("loggedInRole");

        model.addAttribute("beauty", beauty);
        model.addAttribute("reviews", reviews);
        model.addAttribute("averageRating", averageRating);
        model.addAttribute("roleString", role != null ? role.toString() : "CUSTOMER");

        return "provider-reviews";
    }

    @PostMapping("/provider/{beautyId}/reviews/add")
    public String addReview(@PathVariable Long beautyId,
            @RequestParam String reviewerName,
            @RequestParam Integer rating,
            @RequestParam String comment) {

        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        Review review = new Review();
        review.setBeauty(beauty);
        review.setReviewerName(reviewerName);
        review.setRating(rating);
        review.setComment(comment);

        reviewService.createReview(review);

        return "redirect:/provider/" + beautyId + beautyId;
    }

    @PostMapping("/provider-reviews/add")
    public String addReviewForLoggedInProvider(@RequestParam String reviewerName,
            @RequestParam Integer rating,
            @RequestParam String comment,
            HttpSession session) {

        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return addReview(beautyId, reviewerName, rating, comment);
    }

    @GetMapping("/services-page")
    public String showServicesPage(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        List<Service> services = serviceService.getByBeautyId(beautyId);
        model.addAttribute("services", services);

        return "services";
    }

    @GetMapping("/services/create-form")
    public String showCreateServiceForm(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "service-create";
    }

    @PostMapping("/services/create")
    public String createService(Service service, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = new Beauty();
        beauty.setUserId(beautyId);

        service.setBeauty(beauty);
        serviceService.createService(service);

        return "redirect:/services-page";
    }

    @GetMapping("/services/edit/{id}")
    public String showEditServiceForm(@PathVariable Long id, Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Service service = serviceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        model.addAttribute("service", service);
        return "service-edit";
    }

    @PostMapping("/services/update/{id}")
    public String updateService(@PathVariable Long id, Service updatedService, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Service existingService = serviceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setName(updatedService.getName());
        existingService.setDescription(updatedService.getDescription());
        existingService.setPrice(updatedService.getPrice());

        serviceService.createService(existingService);

        return "redirect:/services-page";
    }

    @GetMapping("/services/delete/{id}")
    public String deleteService(@PathVariable Long id, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        serviceService.deleteService(id);
        return "redirect:/services-page";
    }

    @GetMapping("/availability-page")
    public String showAvailabilityPage(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        List<Availability> list = availabilityService.getByBeautyId(beautyId);
        model.addAttribute("availabilities", list);

        return "availability";
    }

    @GetMapping("/availability/create-form")
    public String showCreateAvailabilityForm(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "availability-create";
    }

    @PostMapping("/availability/create")
    public String createAvailability(Availability availability, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = new Beauty();
        beauty.setUserId(beautyId);

        availability.setBeauty(beauty);
        availabilityService.createAvailability(availability);

        return "redirect:/availability-page";
    }

    @GetMapping("/availability/delete/{id}")
    public String deleteAvailability(@PathVariable Long id, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        availabilityService.deleteAvailability(id);
        return "redirect:/availability-page";
    }

    @GetMapping("/provider-bookings/confirm/{id}")
    public String confirmBooking(@PathVariable Long id, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        bookingService.confirmBooking(id);

        return "redirect:/provider-bookings";
    }

}