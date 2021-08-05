package com.example.model.service.contract;

import com.example.model.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService {
    void save(Contract contract);

    void delete(Long id);

    Contract findByContractId(Long id);

    Page<Contract> findAllByEmployeeName(Pageable pageable,String employeeName);

    List<Contract> findAll();
}
