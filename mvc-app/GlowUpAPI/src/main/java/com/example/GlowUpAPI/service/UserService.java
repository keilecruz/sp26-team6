package com.example.GlowUpAPI.service;

import com.example.GlowUpAPI.entity.User;
import com.example.GlowUpAPI.repository.UserRepository;
import com.example.GlowUpAPI.entity.Beauty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public List<User> getAllProviders() {
    return userRepository.findByRole(User.Role.BEAUTY);
    }

    public List<Beauty> getAllBeautyProviders() {
    return userRepository.findByRole(User.Role.BEAUTY)
            .stream()
            .filter(user -> user instanceof Beauty)
            .map(user -> (Beauty) user)
            .toList();
}

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}