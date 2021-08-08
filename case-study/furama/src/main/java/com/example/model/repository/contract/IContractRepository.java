package com.example.model.repository.contract;

import com.example.model.entity.Contract;
import com.example.model.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Long> {
    Contract findByContractId(Long id);

    @Query(value = "select * from contract c join customer cu on c.customer_id = cu.customer_id where cu.customer_name like :customerName and c.flag=1", nativeQuery = true)
    Page<Contract> findAllByCustomerName(Pageable pageable, @Param("customerName") String customerName);

    @Query(value = "select * from contract where flag=1", nativeQuery = true)
    List<Contract> findAll();

    @Query(value ="select * from contract co join customer cu on co.customer_id=cu.customer_id where cu.customer_id like :id and co.flag=1",nativeQuery = true)
    Page<Contract> findByCustomer(Pageable pageable,@Param("id") Long id);

}
