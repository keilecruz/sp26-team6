package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Review;
import com.example.GlowUpAPI.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return reviewRepository.findAll().stream()
                .filter(review -> review.getBeauty() != null
                        && review.getBeauty().getUserId().equals(beautyId))
                .collect(Collectors.toList());
    }

    public List<Review> getReviewsByServiceId(Long serviceId) {
        return reviewRepository.findAll().stream()
                .filter(review -> review.getService() != null
                        && review.getService().getServiceId().equals(serviceId))
                .collect(Collectors.toList());
    }

    public Review updateReview(Long id, Review reviewDetails) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setComment(reviewDetails.getComment());
        review.setRating(reviewDetails.getRating());
        review.setReplyText(reviewDetails.getReplyText());

        return reviewRepository.save(review);
    }

    public Review replyToReview(Long id, String replyText) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setReplyText(replyText);
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}