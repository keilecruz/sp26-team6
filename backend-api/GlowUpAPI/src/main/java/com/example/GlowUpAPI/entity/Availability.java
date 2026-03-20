package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;   // you can upgrade to LocalDate later
    private String time;   // or LocalTime

    @ManyToOne
    @JoinColumn(name = "beauty_id")
    private Beauty beauty;
}