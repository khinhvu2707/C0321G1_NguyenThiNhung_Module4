package com.example.model.repository;

import com.example.model.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServicesRepository extends JpaRepository<Services, Long> {
    List<Services> findAll();
}
