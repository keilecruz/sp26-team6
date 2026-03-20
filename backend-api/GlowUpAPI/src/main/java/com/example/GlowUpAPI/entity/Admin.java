package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admins")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "admin_id")
public class Admin extends User {

    @Column(nullable = false)
    private String adminName;

    // Optional: role auto-set for safety
    @PrePersist
    public void setRole() {
        this.setRole(Role.ADMIN);
    }
}
