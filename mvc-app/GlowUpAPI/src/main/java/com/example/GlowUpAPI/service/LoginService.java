package com.example.GlowUpAPI.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.GlowUpAPI.entity.Login;
import com.example.GlowUpAPI.repository.LoginRepository;

@Service
public class LoginService {

    private final LoginRepository repository;

    public LoginService(LoginRepository repository) {
        this.repository = repository;
    }

    public Optional<Login> authenticate(String email) {
        return repository.findByEmail(email);
    }
}