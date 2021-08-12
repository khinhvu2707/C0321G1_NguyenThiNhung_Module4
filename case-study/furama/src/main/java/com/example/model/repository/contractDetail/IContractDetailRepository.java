package com.example.model.repository.contractDetail;

import com.example.model.entity.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    ContractDetail findByContractDetailId(Long id);

    @Query(value = "select * from contract_detail where flag=1", nativeQuery = true)
    Page<ContractDetail> findAll(Pageable pageable);

    List<ContractDetail> findAllByContract_ContractId(Long id);


}
