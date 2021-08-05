package com.example.model.service.contract.impl;

import com.example.model.entity.Contract;
import com.example.model.repository.contract.IContractRepository;
import com.example.model.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void delete(Long id) {
        contractRepository.delete(findByContractId(id));
    }

    @Override
    public Contract findByContractId(Long id) {
        return contractRepository.findByContractId(id);
    }

    @Override
    public Page<Contract> findAllByEmployeeName(Pageable pageable, String employeeName) {
        return contractRepository.findAllByEmployeeName(pageable, "%"+employeeName+"%");
    }

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }
}
