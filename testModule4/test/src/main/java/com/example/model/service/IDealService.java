package com.example.model.service;

import com.example.model.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IDealService {
    Page<Deal> findAll(Pageable pageable, @Param("service") String service, @Param("name") String name);

    Deal findById(Long id);

    void save(Deal deal);

}
