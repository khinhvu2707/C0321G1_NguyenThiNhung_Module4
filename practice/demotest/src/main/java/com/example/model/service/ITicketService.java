package com.example.model.service;

import com.example.model.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITicketService{
    Page<Ticket> findAll(Pageable pageable);

    void save(Ticket ticket);

    Ticket findById(Long id);
}
