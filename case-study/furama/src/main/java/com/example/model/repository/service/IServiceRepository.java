package com.example.model.repository.service;

import com.example.model.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IServiceRepository extends JpaRepository<Services, Long> {
    Services findByServiceId(Long id);

    @Query(value = "select * from service c where c.service_name like :name and c.flag=1", nativeQuery = true)
    Page<Services> findAllByServiceNameContaining(Pageable pageable,@Param("name") String name);

    @Query(value = "select * from service c where c.flag=1", nativeQuery = true)
    List<Services> findAll();
}
