package com.example.GlowUpAPI.repository;

import com.example.GlowUpAPI.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByCustomerId(Long customerId);

    List<Booking> findByBeauty_UserId(Long beautyId);
}