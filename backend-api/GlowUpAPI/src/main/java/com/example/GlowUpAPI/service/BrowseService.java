package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Browse;
import com.example.GlowUpAPI.repository.BrowseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrowseService {

    private final BrowseRepository browseRepository;

    public BrowseService(BrowseRepository browseRepository) {
        this.browseRepository = browseRepository;
    }

    public List<Browse> getAllProfessionals() {
        return browseRepository.findAll();
    }

    public Browse getById(Long id) {
        return browseRepository.findById(id).orElse(null);
    }

    public Browse save(Browse browse) {
        return browseRepository.save(browse);
    }
}
