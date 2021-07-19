package com.example.model.repository;

import com.example.model.bean.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "pen", 10, "black", "ThienLong"));
        products.put(2, new Product(2, "pen", 10, "red", "ThienLong"));
        products.put(3, new Product(3, "pen", 10, "green", "ThienLong"));
        products.put(4, new Product(4, "pencil", 20, "12 color", "ThienLong"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>(products.values());
        List<Product> searchList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                searchList.add(product);
            }
        }
        return searchList;
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
