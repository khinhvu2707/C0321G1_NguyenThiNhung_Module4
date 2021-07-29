package com.example.model.service;

import com.example.model.bean.Blog;

import java.util.List;

public interface IBlogService {
    Blog findById(Long id);

    List<Blog> findAll();

    List<Blog> findAllByCategoryId(Long id);

}

