package com.example.customermanagement.model.repository;


import com.example.customermanagement.model.bean.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
