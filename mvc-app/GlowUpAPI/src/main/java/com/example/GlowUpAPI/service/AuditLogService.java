package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.AuditLog;
import com.example.GlowUpAPI.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    public AuditLog createLog(AuditLog auditLog) {
        return auditLogRepository.save(auditLog);
    }

    public List<AuditLog> getAllLogs() {
        return auditLogRepository.findAll();
    }

    public Optional<AuditLog> getLogById(Long id) {
        return auditLogRepository.findById(id);
    }

    public List<AuditLog> getLogsByAdmin(Long adminId) {
        return auditLogRepository.findAll().stream()
                .filter(log -> log.getAdmin() != null
                        && log.getAdmin().getUserId().equals(adminId))
                .toList();
    }

    public List<AuditLog> getLogsByType(AuditLog.EntityType type) {
        return auditLogRepository.findAll().stream()
                .filter(log -> log.getEntityType() == type)
                .toList();
    }

    public void deleteLog(Long id) {
        auditLogRepository.deleteById(id);
    }
}