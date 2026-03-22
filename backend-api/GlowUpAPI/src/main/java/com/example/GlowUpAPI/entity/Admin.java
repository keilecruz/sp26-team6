package com.example.GlowUpAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

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

    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("admin")
    private List<AuditLog> auditLogs;

    @PrePersist
    public void setRole() {
        this.setRole(Role.ADMIN);
    }
}