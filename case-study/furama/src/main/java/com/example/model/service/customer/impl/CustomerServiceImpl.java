package com.example.model.service.customer.impl;

import com.example.model.entity.Customer;
import com.example.model.repository.customer.ICustomerRepository;
import com.example.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Customer findByCustomerId(Long id) {
        return customerRepository.findByCustomerId(id);
    }

    @Override
    public Page<Customer> findAllByCustomerNameContaining(Pageable pageable, String name) {
        return customerRepository.findAllByCustomerNameContaining(pageable, name);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(findByCustomerId(id));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
