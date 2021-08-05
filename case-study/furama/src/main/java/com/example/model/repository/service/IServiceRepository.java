package com.example.model.repository.service;

import com.example.model.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceRepository  extends JpaRepository<Services,Long> {
    Services findByServiceId(Long id);

    Page<Services> findAllByServiceNameContaining(Pageable pageable, String name);

    List<Services> findAll();
}
