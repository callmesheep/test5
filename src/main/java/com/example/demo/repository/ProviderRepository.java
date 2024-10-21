package com.example.demo.repository;

import com.example.demo.entity.Providers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.security.Provider;
import java.util.List;
@Repository
public interface ProviderRepository extends JpaRepository<Providers, Long> {
    List<Providers> findBydbStatusFalse();
}
