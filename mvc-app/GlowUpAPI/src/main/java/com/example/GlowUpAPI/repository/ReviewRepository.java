package com.example.GlowUpAPI.repository;

import com.example.GlowUpAPI.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByBeauty_UserId(Long beautyId);
    List<Review> findByCustomerId(Long customerId);

}