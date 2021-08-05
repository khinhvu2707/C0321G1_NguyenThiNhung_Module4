package com.example.model.repository.contractDetail;

import com.example.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository  extends JpaRepository<ContractDetail,Long> {
    ContractDetail findByContractDetailId(Long id);

    Page<ContractDetail> findAll(Pageable pageable);
}
