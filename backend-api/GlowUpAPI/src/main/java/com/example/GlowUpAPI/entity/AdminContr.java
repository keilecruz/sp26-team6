package com.example.GlowUpAPI.entity;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.example.GlowUpAPI.entity.Admin;
import com.example.GlowUpAPI.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminContr {

    private final AdminRepository adminRepository;

    public AdminContr(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin updatedAdmin) {
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setEmail(updatedAdmin.getEmail());
                    admin.setPassword(updatedAdmin.getPassword());
                    admin.setAdminName(updatedAdmin.getAdminName());
                    return adminRepository.save(admin);
                })
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        adminRepository.deleteById(id);
    }
}