package com.example.model.service.impl;

import com.example.model.entity.Blog;
import com.example.model.repository.IBlogRepository;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return iBlogRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        iBlogRepository.delete(findById(id));
    }

    @Override
    public Page<Blog> findAllByTitleAnAndCategory(Pageable pageable, String title, String categoryName) {
        return iBlogRepository.findAllByTitleAnAndCategory(pageable, "%" + title + "%", "%"+categoryName+"%");
    }

    @Override
    public List<Blog> findAllByCategoryId(Long id) {
        return iBlogRepository.findAllByCategoryId(id);
    }

}
