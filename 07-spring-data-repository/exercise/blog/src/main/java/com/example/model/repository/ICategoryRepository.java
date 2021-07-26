package com.example.model.repository;

import com.example.model.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ICategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findCategoryByNameLike(String name);
}
