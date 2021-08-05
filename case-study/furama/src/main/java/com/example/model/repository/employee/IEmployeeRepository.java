package com.example.model.repository.employee;

import com.example.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmployeeId(Long id);

    Page<Employee> findAllByEmployeeNameContaining(Pageable pageable, String name);

    List<Employee> findAll();
}
