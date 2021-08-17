package com.example.model.repository;

import com.example.model.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IDealRepository extends JpaRepository<Deal, Long> {
    @Query(value = "select * from deal d join services s on d.service_id=s.service_id join customer c on d.customer=c.customer_id where s.service_name like :service and c.customer_name like :name and d.flag=1", nativeQuery = true)
    Page<Deal> findAll(Pageable pageable, @Param("service") String service, @Param("name") String name);

}
