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

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String time;
    
    @ManyToOne
    @JoinColumn(name = "beauty_id",nullable = false)
    private Beauty beauty;
}
