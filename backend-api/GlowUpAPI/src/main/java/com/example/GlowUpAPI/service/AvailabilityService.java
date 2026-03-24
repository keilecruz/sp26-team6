package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Availability;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {

    public Availability createAvailability(Availability availability) {
        return availability;
    }

    public List<Availability> getAllAvailability() {
        return new ArrayList<>();
    }

    public Optional<Availability> getAvailabilityById(Long id) {
        return Optional.empty();
    }

    public List<Availability> getAvailabilityByBeautyId(Long beautyId) {
        return new ArrayList<>();
    }

    public Availability updateAvailability(Long id, Availability availabilityDetails) {
        return availabilityDetails;
    }

    public void deleteAvailability(Long id) {
    }
}