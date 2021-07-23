package com.example.model.repository;

import com.example.model.bean.Blog;
import com.example.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAllByCategory_Id(Long id, Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAll(Pageable pageable);
}
