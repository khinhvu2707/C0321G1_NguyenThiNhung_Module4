package com.example.model.service.impl;

import com.example.model.entity.Category;
import com.example.model.repository.ICategoryRepository;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(findById(id));
    }

    @Override
    public List<Category> findCategoryByNameLike(String name) {
        return categoryRepository.findCategoryByNameLike("%"+name+"%");
    }

}
