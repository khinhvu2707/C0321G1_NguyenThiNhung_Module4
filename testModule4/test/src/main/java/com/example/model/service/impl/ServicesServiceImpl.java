package com.example.model.service.impl;

import com.example.model.entity.Services;
import com.example.model.repository.IServicesRepository;
import com.example.model.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements IServicesService {
   @Autowired
   private IServicesRepository servicesRepository;

    @Override
    public List<Services> findAll() {
        return servicesRepository.findAll();
    }
}
