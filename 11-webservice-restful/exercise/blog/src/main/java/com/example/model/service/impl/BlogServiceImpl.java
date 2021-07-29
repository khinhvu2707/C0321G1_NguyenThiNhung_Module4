package com.example.model.service.impl;

import com.example.model.bean.Blog;
import com.example.model.repository.IBlogRepository;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> findAllByCategoryId(Long id) {
        return iBlogRepository.findAllByCategoryId(id);
    }

}
