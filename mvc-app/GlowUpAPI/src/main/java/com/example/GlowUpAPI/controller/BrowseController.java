package com.example.GlowUpAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.service.UserService;

import java.util.List;

@Controller
public class BrowseController {

    private final UserService userService;

    public BrowseController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/browse")
    public String browsePage(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category,
            Model model) {

        List<Beauty> providers = userService.getAllBeautyProviders();

        if (keyword != null && !keyword.isBlank()) {
            String lowerKeyword = keyword.toLowerCase();

            providers = providers.stream()
                    .filter(p -> (p.getBusinessName() != null &&
                            p.getBusinessName().toLowerCase().contains(lowerKeyword))
                            ||
                            (p.getSpecialty() != null &&
                                    p.getSpecialty().toLowerCase().contains(lowerKeyword)))
                    .toList();
        }

        if (category != null && !category.isBlank()) {
            providers = providers.stream()
                    .filter(p -> p.getSpecialty() != null &&
                            p.getSpecialty().equalsIgnoreCase(category))
                    .toList();
        }

        model.addAttribute("providers", providers);
        model.addAttribute("keyword", keyword);
        model.addAttribute("category", category);

        return "customer-browse";
    }
}