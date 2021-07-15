package com.example.service;

import com.example.repository.CaculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService {

    @Autowired
    private CaculatorRepository caculatorRepository;

    @Override
    public String Calculate(float firstOperand, float secondOperand, String operator) {
        return caculatorRepository.Calculate(firstOperand, secondOperand, operator);
    }
}
