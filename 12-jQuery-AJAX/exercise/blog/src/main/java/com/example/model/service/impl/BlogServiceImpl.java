package com.example.model.service.impl;

import com.example.model.bean.Blog;
import com.example.model.repository.IBlogRepository;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAllByTitleContaining(Pageable pageable, String title) {
        return iBlogRepository.findAllByTitleContaining(pageable,title);
    }

}
