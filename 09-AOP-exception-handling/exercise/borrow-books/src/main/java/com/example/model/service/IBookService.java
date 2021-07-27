package com.example.model.service;

import com.example.exception.NotFoundException;
import com.example.model.entity.Book;

import java.util.List;

public interface IBookService {
    Book findById(Long id);
    void save(Book book);
    Book findByCode(String code) throws NotFoundException;
    List<Book> findAll();
}
