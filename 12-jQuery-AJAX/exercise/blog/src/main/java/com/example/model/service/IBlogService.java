package com.example.model.service;

import com.example.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAllByTitleContaining(Pageable pageable, String title);
}

