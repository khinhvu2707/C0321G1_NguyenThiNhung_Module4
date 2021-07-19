package com.example.model.repository;

import com.example.model.bean.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    Product save(Product product);

    Product findById(int id);

    List<Product> findByName(String name);

    void update(int id, Product product);

    void remove(int id);
}
