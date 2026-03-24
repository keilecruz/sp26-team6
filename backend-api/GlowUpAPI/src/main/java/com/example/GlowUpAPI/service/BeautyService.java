package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Beauty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BeautyService {

    public Beauty createBeauty(Beauty beauty) {
        return beauty;
    }

    public List<Beauty> getAllBeauties() {
        return new ArrayList<>();
    }

    public Optional<Beauty> getBeautyById(Long id) {
        return Optional.empty();
    }

    public List<Beauty> getBeautiesBySpecialty(String specialty) {
        return new ArrayList<>();
    }

    public Beauty updateBeauty(Long id, Beauty beautyDetails) {
        return beautyDetails;
    }

    public void deleteBeauty(Long id) {
    }
}