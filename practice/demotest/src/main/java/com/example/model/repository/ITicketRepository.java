package com.example.model.repository;

import com.example.model.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITicketRepository extends JpaRepository<Ticket,Long> {
    @Query(value="select * from ticket t where t.flag=1",nativeQuery = true)
    Page<Ticket> findAll(Pageable pageable);
}
