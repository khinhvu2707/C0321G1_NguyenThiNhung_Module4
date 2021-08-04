package com.example.model.repository.service;

import com.example.model.entity.Contract;
import com.example.model.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IServiceRepository  extends JpaRepository<Service,Long> {
    Service findByServiceId(Long id);

    Page<Service> findAll(Pageable pageable);
}
