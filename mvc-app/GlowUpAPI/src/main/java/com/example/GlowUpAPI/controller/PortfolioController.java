package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Portfolio;
import com.example.GlowUpAPI.service.PortfolioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/portfolios")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    // create portfolio
    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio) {
        Portfolio createdPortfolio = portfolioService.createPortfolio(portfolio);
        return new ResponseEntity<>(createdPortfolio, HttpStatus.CREATED);
    }

    // get all portfolios
    @GetMapping
    public ResponseEntity<List<Portfolio>> getAllPortfolios() {
        List<Portfolio> portfolios = portfolioService.getAllPortfolios();
        return new ResponseEntity<>(portfolios, HttpStatus.OK);
    }

    // get portfolio by ID
    @GetMapping("/{id}")
    public ResponseEntity<Portfolio> getPortfolioById(@PathVariable Long id) {
        return portfolioService.getPortfolioById(id)
                .map(portfolio -> new ResponseEntity<>(portfolio, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // get portfolios 
    @GetMapping("/beauty/{beautyId}")
    public ResponseEntity<List<Portfolio>> getPortfoliosByBeauty(@PathVariable Long beautyId) {
        List<Portfolio> portfolios = portfolioService.getPortfoliosByBeautyId(beautyId);
        return new ResponseEntity<>(portfolios, HttpStatus.OK);
    }

    // update portfolio
    @PutMapping("/{id}")
    public ResponseEntity<Portfolio> updatePortfolio(@PathVariable Long id, @RequestBody Portfolio portfolioDetails) {
        try {
            Portfolio updatedPortfolio = portfolioService.updatePortfolio(id, portfolioDetails);
            return new ResponseEntity<>(updatedPortfolio, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // delete portfolio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePortfolio(@PathVariable Long id) {
        portfolioService.deletePortfolio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}