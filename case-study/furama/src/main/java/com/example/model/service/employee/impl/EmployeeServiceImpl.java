package com.example.model.service.employee.impl;

import com.example.model.entity.Employee;
import com.example.model.repository.employee.IEmployeeRepository;
import com.example.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Employee findByEmployeeId(Long id) {
        return employeeRepository.findByEmployeeId(id);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.delete(findByEmployeeId(id));
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name) {
        return employeeRepository.findAllByEmployeeNameContaining(pageable, name);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
