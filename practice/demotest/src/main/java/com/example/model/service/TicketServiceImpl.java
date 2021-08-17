package com.example.model.service;

import com.example.model.entity.Ticket;
import com.example.model.repository.ITicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ITicketService {
   @Autowired
   private ITicketRepository ticketRepository;

    @Override
    public Page<Ticket> findAll(Pageable pageable) {
        return ticketRepository.findAll(pageable);
    }

    @Override
    public void save(Ticket ticket) {
ticketRepository.save(ticket);
    }

    @Override
    public Ticket findById(Long id) {
        return ticketRepository.findById(id).get();
    }
}
