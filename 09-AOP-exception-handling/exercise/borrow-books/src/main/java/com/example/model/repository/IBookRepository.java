package com.example.model.repository;

import com.example.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {
    Book findByCode(String code);
}
