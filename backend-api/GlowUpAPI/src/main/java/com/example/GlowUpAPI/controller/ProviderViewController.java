package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Availability;
import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.Service;
import com.example.GlowUpAPI.service.AvailabilityService;
import com.example.GlowUpAPI.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProviderViewController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/services-page")
    public String showServicesPage(Model model) {
        List<Service> services = serviceService.getAllServices();
        model.addAttribute("services", services);
        return "services";
    }

    @GetMapping("/services/create-form")
    public String showCreateServiceForm() {
        return "service-create";
    }

    @PostMapping("/services/create")
    public String createService(Service service) {
        Beauty beauty = new Beauty();
        beauty.setUserId(24L);

        service.setBeauty(beauty);
        serviceService.createService(service);

        return "redirect:/services-page";
    }

    @GetMapping("/services/edit/{id}")
    public String showEditServiceForm(@PathVariable Long id, Model model) {
        Service service = serviceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        model.addAttribute("service", service);
        return "service-edit";
    }

    @PostMapping("/services/update/{id}")
    public String updateService(@PathVariable Long id, Service updatedService) {
        Service existingService = serviceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setName(updatedService.getName());
        existingService.setDescription(updatedService.getDescription());
        existingService.setPrice(updatedService.getPrice());

        serviceService.createService(existingService);

        return "redirect:/services-page";
    }

    @GetMapping("/services/delete/{id}")
    public String deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
        return "redirect:/services-page";
    }

    @GetMapping("/availability-page")
    public String showAvailabilityPage(Model model) {
        List<Availability> list = availabilityService.getAllAvailability();
        model.addAttribute("availabilities", list);
        return "availability";
    }

    @GetMapping("/availability/create-form")
    public String showCreateAvailabilityForm() {
        return "availability-create";
    }

    @PostMapping("/availability/create")
    public String createAvailability(Availability availability) {
        Beauty beauty = new Beauty();
        beauty.setUserId(24L);

        availability.setBeauty(beauty);
        availabilityService.createAvailability(availability);

        return "redirect:/availability-page";
    }

    @GetMapping("/availability/delete/{id}")
    public String deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return "redirect:/availability-page";
    }
}