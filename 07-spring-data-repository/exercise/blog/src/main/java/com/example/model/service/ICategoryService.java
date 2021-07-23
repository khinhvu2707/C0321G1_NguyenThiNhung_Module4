package com.example.model.service;

import com.example.model.bean.Category;

import java.util.List;
import java.util.Set;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Long id);

    void delete(Long id);
}
