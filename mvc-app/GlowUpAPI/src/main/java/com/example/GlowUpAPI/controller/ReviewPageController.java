package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.Review;
import com.example.GlowUpAPI.service.BeautyService;
import com.example.GlowUpAPI.service.ReviewService;
import com.example.GlowUpAPI.entity.User;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewPageController {

    private final ReviewService reviewService;
    private final BeautyService beautyService;

    public ReviewPageController(ReviewService reviewService,
            BeautyService beautyService) {
        this.reviewService = reviewService;
        this.beautyService = beautyService;
    }

    // show review form
    @GetMapping("/review/{beautyId}")
    public String showReviewForm(@PathVariable Long beautyId, Model model) {
        model.addAttribute("beautyId", beautyId);
        return "review"; // ← this matches review.ftlh
    }

    // handle form submission
    @PostMapping("/review")
    public String submitReview(@RequestParam Long beautyId,
            @RequestParam String reviewerName,
            @RequestParam Integer rating,
            @RequestParam String comment,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId).orElse(null);

        if (beauty == null) {
            return "redirect:/browse";
        }

        Review review = new Review();
        review.setBeauty(beauty);
        review.setReviewerName(reviewerName);
        review.setRating(rating);
        review.setComment(comment);

        review.setCustomerId(user.getUserId());

        reviewService.createReview(review);

        return "redirect:/provider/" + beautyId;
    }

    @PostMapping("/review/delete")
    public String deleteReview(@RequestParam Long reviewId,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null) {
            return "redirect:/login";
        }

        Review review = reviewService.getReviewById(reviewId).orElse(null);

        if (review == null || !review.getCustomerId().equals(user.getUserId())) {
            return "redirect:/customer-reviews";
        }

        reviewService.deleteReview(reviewId);

        return "redirect:/customer-reviews";
    }

    @GetMapping("/review/edit/{id}")
    public String showEditReview(@PathVariable Long id,
            HttpSession session,
            Model model) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        Review review = reviewService.getReviewById(id).orElse(null);

        // 🔒 Prevent editing others' reviews
        if (review == null || !review.getCustomerId().equals(user.getUserId())) {
            return "redirect:/customer-reviews";
        }

        model.addAttribute("review", review);
        return "edit-review";
    }

    @PostMapping("/review/update")
    public String updateReview(@RequestParam Long reviewId,
            @RequestParam Integer rating,
            @RequestParam String comment,
            HttpSession session) {

        User user = (User) session.getAttribute("loggedInUser");

        if (user == null || user.getRole() != User.Role.CUSTOMER) {
            return "redirect:/login";
        }

        Review review = reviewService.getReviewById(reviewId).orElse(null);

        // 🔒 Prevent editing others' reviews
        if (review != null && review.getCustomerId().equals(user.getUserId())) {
            review.setRating(rating);
            review.setComment(comment);
            reviewService.save(review);
        }

        return "redirect:/customer-reviews";
    }

}
