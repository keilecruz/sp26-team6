package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "replies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    @JsonIgnoreProperties("replies")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "beauty_id", nullable = false)
    @JsonIgnoreProperties("replies")
    private Beauty beauty;
}