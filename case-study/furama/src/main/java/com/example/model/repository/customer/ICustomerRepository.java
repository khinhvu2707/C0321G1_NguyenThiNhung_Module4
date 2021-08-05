package com.example.model.repository.customer;

import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long id);

    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);

    List<Customer> findAll();
}
