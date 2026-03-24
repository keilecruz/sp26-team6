package com.example.GlowUpAPI.repository;

import com.example.GlowUpAPI.entity.Beauty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeautyRepository extends JpaRepository<Beauty, Long> {
}