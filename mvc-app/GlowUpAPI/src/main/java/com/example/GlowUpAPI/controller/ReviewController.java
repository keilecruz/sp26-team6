package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Review;
import com.example.GlowUpAPI.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // create review
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        Review createdReview = reviewService.createReview(review);
        return new ResponseEntity<>(createdReview, HttpStatus.CREATED);
    }

    // get ll reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewService.getReviewById(id)
                .map(review -> new ResponseEntity<>(review, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // get reviews by Beauty (provider)
    @GetMapping("/beauty/{beautyId}")
    public ResponseEntity<List<Review>> getReviewsByBeauty(@PathVariable Long beautyId) {
        List<Review> reviews = reviewService.getReviewsByBeautyId(beautyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // get reviews by Service
    @GetMapping("/service/{serviceId}")
    public ResponseEntity<List<Review>> getReviewsByService(@PathVariable Long serviceId) {
        List<Review> reviews = reviewService.getReviewsByServiceId(serviceId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    // update review (edit rating/comment)
    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review reviewDetails) {
        try {
            Review updatedReview = reviewService.updateReview(id, reviewDetails);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // provider reply to review
    @PutMapping("/{id}/reply")
    public ResponseEntity<Review> replyToReview(@PathVariable Long id, @RequestBody String replyText) {
        try {
            Review updatedReview = reviewService.replyToReview(id, replyText);
            return new ResponseEntity<>(updatedReview, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete review (admin)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}