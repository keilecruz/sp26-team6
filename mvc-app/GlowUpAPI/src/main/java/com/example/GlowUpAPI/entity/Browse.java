package com.example.GlowUpAPI.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Browse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private int experience;
    private double rating;
    private String imageUrl;

    public Browse() {}

    public Browse(Long id, String name, String specialty, int experience, double rating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.experience = experience;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public String getSpecialty() { return specialty; }

    public int getExperience() { return experience; }

    public double getRating() { return rating; }

    public String getImageUrl() { return imageUrl; }

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public void setExperience(int experience) { this.experience = experience; }

    public void setRating(double rating) { this.rating = rating; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}