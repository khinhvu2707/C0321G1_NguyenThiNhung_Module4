package com.example.model.service.customer;

import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Customer findByCustomerId(Long id);

    Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name);

    void save(Customer customer);

    void delete(Long id);
}
