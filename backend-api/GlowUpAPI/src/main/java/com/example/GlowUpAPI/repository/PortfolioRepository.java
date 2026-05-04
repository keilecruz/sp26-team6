package com.example.GlowUpAPI.repository;

import com.example.GlowUpAPI.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByBeauty_UserId(Long beautyId);
}
