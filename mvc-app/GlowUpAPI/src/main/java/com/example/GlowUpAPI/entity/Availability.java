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

    private String date;   
    private String time;   

    @ManyToOne
    @JoinColumn(name = "beauty_id",nullable = false)
    private Beauty beauty;
}
