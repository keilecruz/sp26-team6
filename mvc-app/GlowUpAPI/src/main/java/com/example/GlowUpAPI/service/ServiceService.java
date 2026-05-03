package com.example.GlowUpAPI.service;

//example 
import com.example.GlowUpAPI.repository.BeautyRepository;
import com.example.GlowUpAPI.entity.Beauty;

import com.example.GlowUpAPI.entity.Service;
import com.example.GlowUpAPI.repository.ServiceRepository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    // example
    @Autowired
    private BeautyRepository beautyRepository;

    public Service createService(Service service) {
        return serviceRepository.save(service);
    }

    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }

    public List<Service> getServicesByBeautyId(Long beautyId) {
        return serviceRepository.findAll().stream()
                .filter(service -> service.getBeauty() != null
                        && service.getBeauty().getUserId().equals(beautyId))
                .toList();
    }

    public Service updateService(Long id, Service serviceDetails) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        service.setName(serviceDetails.getName());
        service.setPrice(serviceDetails.getPrice());
        service.setDescription(serviceDetails.getDescription());
        service.setBeauty(serviceDetails.getBeauty());

        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }


    // adding in logic for customer to browse through professionals
    public List<Service> searchServices(String keyword, String category) {

        List<Service> all = serviceRepository.findAll();

        return all.stream()
                .filter(service -> {

                    boolean matchesKeyword = true;
                    boolean matchesCategory = true;

                    // search
                    if (keyword != null && !keyword.isEmpty()) {
                        matchesKeyword = service.getName().toLowerCase().contains(keyword.toLowerCase())
                                || service.getDescription().toLowerCase().contains(keyword.toLowerCase());
                    }

                    // filter
                    if (category != null && !category.isEmpty()) {
                        matchesCategory = service.getBeauty() != null &&
                                service.getBeauty().getSpecialty() != null &&
                                service.getBeauty().getSpecialty().toLowerCase().contains(category.toLowerCase());
                    }

                    return matchesKeyword && matchesCategory;
                })
                .toList();
    }
}