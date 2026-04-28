package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Availability;
import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.repository.AvailabilityRepository;
import com.example.GlowUpAPI.repository.BeautyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
        long beautyId = availability.getBeauty().getUserId();

        Beauty beauty = beautyRepository.findById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty not found"));

        availability.setBeauty(beauty);

        return availabilityRepository.save(availability);
    }

    public List<Availability> getAllAvailability() {
        return availabilityRepository.findAll();
    }

    public Optional<Availability> getAvailabilityById(@NonNull Long id) {
        return availabilityRepository.findById(id);
    }

    public List<Availability> getAvailabilityByBeautyId(Long beautyId) {
        return availabilityRepository.findAll().stream()
                .filter(a -> a.getBeauty() != null && a.getBeauty().getUserId().equals(beautyId))
                .toList();
    }

    public Availability updateAvailability(@NonNull Long id, Availability availabilityDetails) {
        Availability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));

        availability.setDate(availabilityDetails.getDate());
        availability.setTime(availabilityDetails.getTime());

        if (availabilityDetails.getBeauty() != null) {
            long beautyId = availabilityDetails.getBeauty().getUserId();

            Beauty beauty = beautyRepository.findById(beautyId)
                    .orElseThrow(() -> new RuntimeException("Beauty not found"));

            availability.setBeauty(beauty);
        }

        return availabilityRepository.save(availability);
    }

    public void deleteAvailability(@NonNull Long id) {
        availabilityRepository.deleteById(id);
    }
}
