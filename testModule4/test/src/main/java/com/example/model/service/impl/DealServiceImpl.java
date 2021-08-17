package com.example.model.service.impl;

import com.example.model.entity.Deal;
import com.example.model.repository.IDealRepository;
import com.example.model.service.IDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DealServiceImpl implements IDealService {
    @Autowired
    private IDealRepository dealRepository;

    @Override
    public Page<Deal> findAll(Pageable pageable, String service, String name) {
        return dealRepository.findAll(pageable, "%"+service+"%", "%" + name + "%");
    }

    @Override
    public Deal findById(Long id) {
        return dealRepository.findById(id).get();
    }

    @Override
    public void save(Deal deal) {
        dealRepository.save(deal);
    }

}
