package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Review;
import com.example.GlowUpAPI.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public List<Review> getReviewsByBeautyId(Long beautyId) {
        return reviewRepository.findByBeauty_UserId(beautyId);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}