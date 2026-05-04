package com.example.GlowUpAPI.repository;

import com.example.GlowUpAPI.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; 

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findByBeauty_UserId(Long beautyId);
}