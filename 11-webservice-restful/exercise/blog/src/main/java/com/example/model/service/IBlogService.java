package com.example.model.service;

import com.example.model.bean.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Optional<Blog> findById(Long id);

    List<Blog> findAll();

    List<Blog> findAllByCategoryId(Long id);

}

