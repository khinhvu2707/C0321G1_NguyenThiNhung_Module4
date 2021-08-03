package com.example.model.service;

import com.example.model.entity.Category;
import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    Category findById(Long id);

    void delete(Long id);

    List<Category> findCategoryByNameLike(String name);
}
