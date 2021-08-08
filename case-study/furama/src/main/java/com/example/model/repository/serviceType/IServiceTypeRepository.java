package com.example.model.repository.serviceType;

import com.example.model.entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IServiceTypeRepository extends JpaRepository<ServiceType,Long> {
    List<ServiceType> findAll();
}
