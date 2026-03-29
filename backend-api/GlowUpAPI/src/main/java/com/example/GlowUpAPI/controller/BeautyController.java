package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.service.BeautyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beauties")
public class BeautyController {

    @Autowired
    private BeautyService beautyService;

    // create Beauty (provider profile)
    @PostMapping
    public ResponseEntity<Beauty> createBeauty(@RequestBody Beauty beauty) {
        Beauty createdBeauty = beautyService.createBeauty(beauty);
        return new ResponseEntity<>(createdBeauty, HttpStatus.CREATED);
    }
    
    // get all Beauty professionals
    @GetMapping
    public ResponseEntity<List<Beauty>> getAllBeauties() {
        List<Beauty> beauties = beautyService.getAllBeauties();
        return new ResponseEntity<>(beauties, HttpStatus.OK);
    }

    // get Beauty by ID
    @GetMapping("/{id}")
    public ResponseEntity<Beauty> getBeautyById(@PathVariable Long id) {
        return beautyService.getBeautyById(id)
                .map(beauty -> new ResponseEntity<>(beauty, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // get Beauty by specialty
    @GetMapping("/specialty/{specialty}")
    public ResponseEntity<List<Beauty>> getBeautiesBySpecialty(@PathVariable String specialty) {
        List<Beauty> beauties = beautyService.getBeautiesBySpecialty(specialty);
        return new ResponseEntity<>(beauties, HttpStatus.OK);
    }

    // update Beauty profile
    @PutMapping("/{id}")
    public ResponseEntity<Beauty> updateBeauty(@PathVariable Long id, @RequestBody Beauty beautyDetails) {
        try {
            Beauty updatedBeauty = beautyService.updateBeauty(id, beautyDetails);
            return new ResponseEntity<>(updatedBeauty, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete Beauty
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBeauty(@PathVariable Long id) {
        beautyService.deleteBeauty(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}