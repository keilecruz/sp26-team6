package com.example.GlowUpAPI.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.GlowUpAPI.entity.Browse;
import com.example.GlowUpAPI.service.BrowseService;

@Controller
public class BrowseController {

    private final BrowseService browseService;

    public BrowseController(BrowseService browseService) {
        this.browseService = browseService;
    }

    @GetMapping("/browse")
        public String browsePage(Model model) {
        model.addAttribute("professionals", List.of());
         return "browse";
    }   
}