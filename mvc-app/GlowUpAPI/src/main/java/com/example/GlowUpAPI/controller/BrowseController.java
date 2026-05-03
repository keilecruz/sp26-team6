package com.example.GlowUpAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.GlowUpAPI.service.ServiceService;
import java.util.List;
import com.example.GlowUpAPI.entity.Service;

@Controller
public class BrowseController {

    private final ServiceService serviceService;

    public BrowseController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/browse")
    public String browsePage(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String category,
            Model model) {

        List<Service> services = serviceService.searchServices(keyword, category);

        model.addAttribute("services", services);

        return "browse";
    }
}