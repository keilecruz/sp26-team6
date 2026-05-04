package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Availability;
import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.repository.AvailabilityRepository;
import com.example.GlowUpAPI.repository.BeautyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvailabilityService {

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Autowired
    private BeautyRepository beautyRepository;

    public Availability createAvailability(Availability availability) {
        Long beautyId = availability.getBeauty().getUserId();

        Beauty beauty = beautyRepository.findById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty not found"));

        availability.setBeauty(beauty);

        return availabilityRepository.save(availability);
    }

    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    public Availability getById(Long id) {
        return availabilityRepository.findById(id).orElse(null);
    }

    public List<Availability> getByBeautyId(Long beautyId) {
        return availabilityRepository.findAll().stream()
                .filter(a -> a.getBeauty() != null && a.getBeauty().getUserId().equals(beautyId))
                .toList();
    }

    public Availability updateAvailability(Long id, Availability availabilityDetails) {
        Availability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));

        availability.setDate(availabilityDetails.getDate());
        availability.setTime(availabilityDetails.getTime());

        if (availabilityDetails.getBeauty() != null) {
            Long beautyId = availabilityDetails.getBeauty().getUserId();

            Beauty beauty = beautyRepository.findById(beautyId)
                    .orElseThrow(() -> new RuntimeException("Beauty not found"));

            availability.setBeauty(beauty);
        }

        return availabilityRepository.save(availability);
    }

    public void deleteAvailability(Long id) {
        availabilityRepository.deleteById(id);
    }
}