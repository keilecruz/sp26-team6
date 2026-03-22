package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

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
    private String titleName;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "beauty_id", nullable = false)
    @JsonIgnoreProperties("portfolios")
    private Beauty beauty;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("portfolio")
    private List<Service> services;
}
