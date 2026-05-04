package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Portfolio;
import com.example.GlowUpAPI.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    public Optional<Portfolio> getPortfolioById(Long id) {
        return portfolioRepository.findById(id);
    }

    public List<Portfolio> getPortfoliosByBeautyId(Long beautyId) {
        return portfolioRepository.findByBeauty_UserId(beautyId);
    }

    public Portfolio updatePortfolio(Long id, Portfolio portfolioDetails) {
        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sample work photo not found"));

        portfolio.setImageUrl(portfolioDetails.getImageUrl());

        return portfolioRepository.save(portfolio);
    }

    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }

    public boolean belongsToBeauty(Long portfolioId, Long beautyId) {
        Optional<Portfolio> portfolioOptional = portfolioRepository.findById(portfolioId);

        if (portfolioOptional.isEmpty()) {
            return false;
        }

        Portfolio portfolio = portfolioOptional.get();

        return portfolio.getBeauty() != null
                && portfolio.getBeauty().getUserId().equals(beautyId);
    }
}