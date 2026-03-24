package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.Service;
import com.example.GlowUpAPI.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

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
}