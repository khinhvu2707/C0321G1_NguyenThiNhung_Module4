package com.example.model.service.contractDetail;

import com.example.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    void delete(Long id);

    ContractDetail findByContractDetailId(Long id);

    Page<ContractDetail> findAll(Pageable pageable);
}
