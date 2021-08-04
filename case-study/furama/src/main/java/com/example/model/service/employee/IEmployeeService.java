package com.example.model.service.employee;

import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEmployeeService {
    void save(Employee employee);

    Employee findByEmployeeId(Long id);

    void delete(Long id);

    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);
}
