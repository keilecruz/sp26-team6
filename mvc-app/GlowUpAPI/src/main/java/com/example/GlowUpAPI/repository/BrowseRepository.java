package com.example.GlowUpAPI.repository;

import com.example.GlowUpAPI.entity.Browse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrowseRepository extends JpaRepository<Browse, Long> {
}
