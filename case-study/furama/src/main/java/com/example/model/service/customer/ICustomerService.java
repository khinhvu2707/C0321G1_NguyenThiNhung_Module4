package com.example.model.service.customer;

import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Customer findByCustomerId(Long id);

    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);

    void save(Customer customer);

    void delete(Long id);

    List<Customer> findAll();
}
