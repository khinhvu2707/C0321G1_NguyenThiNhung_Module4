package com.example.model.repository.service.rentType;

import com.example.model.entity.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRentTypeRepository extends JpaRepository<RentType,Long> {
    List<RentType> findAll();
}
