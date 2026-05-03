package com.example.GlowUpAPI.controller;

import com.example.GlowUpAPI.entity.AuditLog;
import com.example.GlowUpAPI.service.AuditLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit-logs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    // create audit log
    @PostMapping
    public ResponseEntity<AuditLog> createLog(@RequestBody AuditLog auditLog) {
        AuditLog created = auditLogService.createLog(auditLog);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // get all logs
    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllLogs() {
        List<AuditLog> logs = auditLogService.getAllLogs();
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // get log by ID
    @GetMapping("/{id}")
    public ResponseEntity<AuditLog> getLogById(@PathVariable Long id) {
        return auditLogService.getLogById(id)
                .map(log -> new ResponseEntity<>(log, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // get logs by Admin
    @GetMapping("/admin/{adminId}")
    public ResponseEntity<List<AuditLog>> getLogsByAdmin(@PathVariable Long adminId) {
        List<AuditLog> logs = auditLogService.getLogsByAdmin(adminId);
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // get logs by Entity Type
    @GetMapping("/type/{type}")
    public ResponseEntity<List<AuditLog>> getLogsByType(@PathVariable AuditLog.EntityType type) {
        List<AuditLog> logs = auditLogService.getLogsByType(type);
        return new ResponseEntity<>(logs, HttpStatus.OK);
    }

    // delete log 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLog(@PathVariable Long id) {
        auditLogService.deleteLog(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

