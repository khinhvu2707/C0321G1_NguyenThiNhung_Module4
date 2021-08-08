package com.example.model.service.contractDetail.impl;

import com.example.model.entity.ContractDetail;
import com.example.model.repository.contractDetail.IContractDetailRepository;
import com.example.model.service.contractDetail.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public ContractDetail findByContractDetailId(Long id) {
        return contractDetailRepository.findByContractDetailId(id);
    }

    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return contractDetailRepository.findAll(pageable);
    }

    @Override
    public List<ContractDetail> findAllByContract_ContractId(Long id) {
        return contractDetailRepository.findAllByContract_ContractId(id);
    }
}
