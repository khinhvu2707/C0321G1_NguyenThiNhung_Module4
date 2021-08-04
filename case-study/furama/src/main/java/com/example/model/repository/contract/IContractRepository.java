package com.example.model.repository.contract;

import com.example.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface IContractRepository extends JpaRepository<Contract,Long> {
    Contract findByContractId(Long id);

    Page<Contract> findAll(Pageable pageable);
}
