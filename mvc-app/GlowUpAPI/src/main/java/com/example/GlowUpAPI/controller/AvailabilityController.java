package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Availability;
import com.example.GlowUpAPI.service.AvailabilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    // create availability slot
    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        Availability created = availabilityService.createAvailability(availability);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // get all availability
    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailability() {
        List<Availability> list = availabilityService.getAllAvailability();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // get by ID
    @GetMapping("/{id}")
    public ResponseEntity<Availability> getAvailabilityById(@PathVariable Long id) {

        Availability availability = availabilityService.getById(id);

        return new ResponseEntity<>(availability, HttpStatus.OK);
    }

    // get availability by Beauty
    @GetMapping("/beauty/{beautyId}")
    public ResponseEntity<List<Availability>> getAvailabilityByBeauty(@PathVariable Long beautyId) {
        List<Availability> list = availabilityService.getByBeautyId(beautyId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    // update availability
    @PutMapping("/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable Long id,
            @RequestBody Availability details) {
        try {
            Availability updated = availabilityService.updateAvailability(id, details);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete availability
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}