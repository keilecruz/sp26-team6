package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Portfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolio;
    }

    public List<Portfolio> getAllPortfolios() {
        return new ArrayList<>();
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return Optional.empty();
    }

    public List<Portfolio> getPortfoliosByBeautyId(Long beautyId) {
        return new ArrayList<>();
    }

    public Portfolio updatePortfolio(Long id, Portfolio portfolioDetails) {
        return portfolioDetails;
    }

    public void deletePortfolio(Long id) {
    }
}