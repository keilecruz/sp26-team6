package com.example.GlowUpAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "portfolios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioId;

    @Column(nullable = false)
    private String imageUrl;

    @Column
    private String caption;

    @ManyToOne
    @JoinColumn(name = "beauty_id")
    @JsonIgnoreProperties("portfolios")
    private Beauty beauty;
}