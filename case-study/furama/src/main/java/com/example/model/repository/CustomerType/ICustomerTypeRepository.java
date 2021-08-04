package com.example.model.repository.CustomerType;

import com.example.model.entity.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
    List<CustomerType> findAll();
}
