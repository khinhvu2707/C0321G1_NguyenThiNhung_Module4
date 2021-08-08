package com.example.model.service.contractDetail;

import com.example.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    ContractDetail findByContractDetailId(Long id);

    Page<ContractDetail> findAll(Pageable pageable);

    List<ContractDetail> findAllByContract_ContractId(Long id);
}
