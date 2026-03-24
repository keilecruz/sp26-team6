package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.repository.BeautyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeautyService {

    @Autowired
    private BeautyRepository beautyRepository;

    public Beauty createBeauty(Beauty beauty) {
        return beautyRepository.save(beauty);
    }

    public List<Beauty> getAllBeauties() {
        return beautyRepository.findAll();
    }

    public Optional<Beauty> getBeautyById(Long id) {
        return beautyRepository.findById(id);
    }

    public List<Beauty> getBeautiesBySpecialty(String specialty) {
        return beautyRepository.findAll().stream()
                .filter(b -> b.getSpecialty() != null && b.getSpecialty().equalsIgnoreCase(specialty))
                .toList();
    }

    public Beauty updateBeauty(Long id, Beauty beautyDetails) {
        Beauty beauty = beautyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Beauty not found"));

        beauty.setEmail(beautyDetails.getEmail());
        beauty.setPassword(beautyDetails.getPassword());
        beauty.setRole(beautyDetails.getRole());
        beauty.setBusinessName(beautyDetails.getBusinessName());
        beauty.setSpecialty(beautyDetails.getSpecialty());

        return beautyRepository.save(beauty);
    }

    public void deleteBeauty(Long id) {
        beautyRepository.deleteById(id);
    }
}