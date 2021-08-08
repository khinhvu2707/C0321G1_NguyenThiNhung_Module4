package com.example.model.service.contract;

import com.example.model.entity.Contract;
import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractService {
    void save(Contract contract);

    Contract findByContractId(Long id);

    Page<Contract> findAllByCustomerName(Pageable pageable,String employeeName);

    List<Contract> findAll();

    Page<Contract> findByCustomer(Pageable pageable,Long id);

}
