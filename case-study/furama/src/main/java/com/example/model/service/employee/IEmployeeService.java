package com.example.model.service.employee;

import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IEmployeeService {
    void save(Employee employee);

    Employee findByEmployeeId(Long id);

    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name,String position);

    List<Employee> findAll();
}
