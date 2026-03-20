package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // your fields here (date, time, etc.)
}