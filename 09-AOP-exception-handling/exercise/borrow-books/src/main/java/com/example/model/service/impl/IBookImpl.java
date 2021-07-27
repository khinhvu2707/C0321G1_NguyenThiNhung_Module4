package com.example.model.service.impl;

import com.example.exception.NotFoundException;
import com.example.model.entity.Book;
import com.example.model.repository.IBookRepository;
import com.example.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBookImpl implements IBookService {
    @Autowired
    IBookRepository iBookRepository;


    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findByCode(String code) throws NotFoundException {
        return iBookRepository.findByCode(code);
    }

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }
}
