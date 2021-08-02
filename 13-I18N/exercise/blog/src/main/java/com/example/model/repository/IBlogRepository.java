package com.example.model.repository;

import com.example.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {

    @Query(value = "select * from blog b join category c on b.category_id = c.id where b.title like :title and c.name like :categoryName", nativeQuery = true)
    Page<Blog> findAllByTitleAnAndCategory(Pageable pageable, @Param("title") String title, @Param("categoryName") String categoryName);

    @Query(value = "select * from blog b where b.category_id = :id",nativeQuery = true)
    List<Blog> findAllByCategoryId(@Param("id") Long id);

}
