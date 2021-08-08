package com.example.model.repository.customer;

import com.example.model.entity.Contract;
import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long id);

    @Query(value = "select * from customer c where c.customer_name like :name and c.flag=1", nativeQuery = true)
    Page<Customer> findAllByCustomerNameContaining(Pageable pageable,@Param("name") String name);

    @Query(value = "select * from customer c where c.flag=1", nativeQuery = true)
    List<Customer> findAll();

    @Query(value = "select * from customer cu join contract co on cu.customer_id = co.customer_id where cu.flag=1 and co.flag=1 and cu.customer_name like :name group by cu.customer_id", nativeQuery = true)
    Page<Customer> findAllCustomerUserService(Pageable pageable, @Param("name") String name);
}
