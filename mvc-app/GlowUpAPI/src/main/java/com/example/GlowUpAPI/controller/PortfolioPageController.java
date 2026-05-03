package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.service.BeautyService;
import com.example.GlowUpAPI.service.PortfolioService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PortfolioPageController {

    private final BeautyService beautyService;
    private final PortfolioService portfolioService;

    public PortfolioPageController(BeautyService beautyService,
                                   PortfolioService portfolioService) {
        this.beautyService = beautyService;
        this.portfolioService = portfolioService;
    }

    @GetMapping("/portfolio/{id}")
    public String viewPortfolio(@PathVariable Long id, Model model) {

        Beauty beauty = beautyService.getBeautyById(id)
                .orElseThrow(() -> new RuntimeException("Professional not found"));

        model.addAttribute("beauty", beauty);
        model.addAttribute("portfolios",
                portfolioService.getPortfoliosByBeautyId(id));

        return "portfolio"; // portfolio.ftlh
    }
}