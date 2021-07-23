package com.example.model.service;

import com.example.model.bean.Blog;
import com.example.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Set;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Long id);

    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByCategory_Id(Long id, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

}

