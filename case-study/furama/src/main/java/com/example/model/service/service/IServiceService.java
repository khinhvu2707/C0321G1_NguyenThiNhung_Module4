package com.example.model.service.service;

import com.example.model.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceService {
    void save(Services services);

    Services findByServiceId(Long id);

    void delete(Long id);

    Page<Services> findAllByServiceNameContaining(Pageable pageable, String name);

    List<Services> findAll();
}
