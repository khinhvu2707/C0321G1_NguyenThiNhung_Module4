package com.example.model.service.service.impl;

import com.example.model.entity.Services;
import com.example.model.repository.service.IServiceRepository;
import com.example.model.service.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public void save(Services services) {
        serviceRepository.save(services);
    }

    @Override
    public Services findByServiceId(Long id) {
        return serviceRepository.findByServiceId(id);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.delete(findByServiceId(id));
    }

    @Override
    public Page<Services> findAllByServiceNameContaining(Pageable pageable, String name) {
        return serviceRepository.findAllByServiceNameContaining(pageable, name);
    }

    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }
}
