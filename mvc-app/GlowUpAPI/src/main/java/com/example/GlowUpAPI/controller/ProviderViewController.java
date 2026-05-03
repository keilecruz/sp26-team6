package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.Availability;
import com.example.GlowUpAPI.entity.Beauty;
import com.example.GlowUpAPI.entity.Service;
import com.example.GlowUpAPI.service.AvailabilityService;
import com.example.GlowUpAPI.service.BeautyService;
import com.example.GlowUpAPI.service.ServiceService;

import jakarta.servlet.http.HttpSession;

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

    @Autowired
    private BeautyService beautyService;

    private Long getLoggedInBeautyId(HttpSession session) {
        Object userId = session.getAttribute("loggedInUserId");

        if (userId == null) {
            return null;
        }

        return (Long) userId;
    }

    @GetMapping("/provider-dashboard")
    public String showProviderDashboard(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "provider-dashboard";
    }

    @GetMapping("/provider-profile")
    public String showProviderProfile(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        model.addAttribute("beauty", beauty);

        return "provider-profile";
    }

    @GetMapping("/provider-profile/edit")
    public String showEditProviderProfile(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = beautyService.getBeautyById(beautyId)
                .orElseThrow(() -> new RuntimeException("Beauty profile not found"));

        model.addAttribute("beauty", beauty);

        return "provider-profile-edit";
    }

    @PostMapping("/provider-profile/update")
    public String updateProviderProfile(Beauty updatedBeauty, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        beautyService.updateBeauty(beautyId, updatedBeauty);

        return "redirect:/provider-profile";
    }

    @GetMapping("/provider-bookings")
    public String showProviderBookings(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "provider-bookings";
    }

    @GetMapping("/provider-reviews")
    public String showProviderReviews(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "provider-reviews";
    }

    @GetMapping("/services-page")
    public String showServicesPage(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        List<Service> services = serviceService.getServicesByBeautyId(beautyId);
        model.addAttribute("services", services);

        return "services";
    }

    @GetMapping("/services/create-form")
    public String showCreateServiceForm(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "service-create";
    }

    @PostMapping("/services/create")
    public String createService(Service service, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = new Beauty();
        beauty.setUserId(beautyId);

        service.setBeauty(beauty);
        serviceService.createService(service);

        return "redirect:/services-page";
    }

    @GetMapping("/services/edit/{id}")
    public String showEditServiceForm(@PathVariable Long id, Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Service service = serviceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        model.addAttribute("service", service);
        return "service-edit";
    }

    @PostMapping("/services/update/{id}")
    public String updateService(@PathVariable Long id, Service updatedService, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Service existingService = serviceService.getServiceById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        existingService.setName(updatedService.getName());
        existingService.setDescription(updatedService.getDescription());
        existingService.setPrice(updatedService.getPrice());

        serviceService.createService(existingService);

        return "redirect:/services-page";
    }

    @GetMapping("/services/delete/{id}")
    public String deleteService(@PathVariable Long id, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        serviceService.deleteService(id);
        return "redirect:/services-page";
    }

    @GetMapping("/availability-page")
    public String showAvailabilityPage(Model model, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        List<Availability> list = availabilityService.getAvailabilityByBeautyId(beautyId);
        model.addAttribute("availabilities", list);

        return "availability";
    }

    @GetMapping("/availability/create-form")
    public String showCreateAvailabilityForm(HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        return "availability-create";
    }

    @PostMapping("/availability/create")
    public String createAvailability(Availability availability, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        Beauty beauty = new Beauty();
        beauty.setUserId(beautyId);

        availability.setBeauty(beauty);
        availabilityService.createAvailability(availability);

        return "redirect:/availability-page";
    }

    @GetMapping("/availability/delete/{id}")
    public String deleteAvailability(@PathVariable Long id, HttpSession session) {
        Long beautyId = getLoggedInBeautyId(session);

        if (beautyId == null) {
            return "redirect:/login";
        }

        availabilityService.deleteAvailability(id);
        return "redirect:/availability-page";
    }
}