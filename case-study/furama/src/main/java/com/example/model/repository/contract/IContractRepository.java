package com.example.model.repository.contract;

import com.example.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Long> {
    Contract findByContractId(Long id);

    @Query(value = "select * from contract c join employee e on c.employee_id = e.employee_id where e.employee_name like :employeeName", nativeQuery = true)
    Page<Contract> findAllByEmployeeName(Pageable pageable, @Param("employeeName") String employeeName);

    List<Contract> findAll();
}
