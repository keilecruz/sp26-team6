package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer info
    private Long customerId;

    private String customerName;

    private String customerPhone;

    // Provider
    @ManyToOne
    @JoinColumn(name = "beauty_id", nullable = false)
    private Beauty beauty;

    // Time slot from Availability
    @ManyToOne
    @JoinColumn(name = "availability_id", nullable = false)
    private Availability availability;

    // Service
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    private String status; // CONFIRMED, PENDING
}