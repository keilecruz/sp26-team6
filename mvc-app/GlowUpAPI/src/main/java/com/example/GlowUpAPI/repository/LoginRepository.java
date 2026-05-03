package com.example.GlowUpAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.GlowUpAPI.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByEmail(String email);
}
