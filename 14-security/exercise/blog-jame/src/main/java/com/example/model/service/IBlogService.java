package com.example.model.service;

import com.example.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {

    void save(Blog blog);

    Blog findById(Long id);

    void delete(Long id);

    Page<Blog> findAllByTitleAnAndCategory(Pageable pageable,String title,String categoryName);

    List<Blog> findAllByCategoryId(Long id);

}

