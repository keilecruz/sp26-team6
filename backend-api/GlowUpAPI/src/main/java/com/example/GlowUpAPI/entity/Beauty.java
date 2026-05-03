package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@Entity
@Table(name = "beauty_professionals")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "beauty_id")

public class Beauty extends User {
    
    @Column(nullable = false)
    private String businessName;

    @Column
    private String specialty;
    
    @Column(length = 1000)
    private String bio;

    @Column
    private String profileImage;

    @OneToMany(mappedBy = "beauty", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("beauty")
    private List<Portfolio> portfolios;

    @OneToMany(mappedBy = "beauty", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("beauty")
    private List<Availability> availabilities;

    @OneToMany(mappedBy = "beauty", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("beauty")
    private List<Reply> replies;

}
