package com.example.model.repository.impl;

import com.example.model.bean.Product;
import com.example.model.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    @Override
    public List<Product> findAll() {
        String queryStr = "SELECT c FROM Product AS c";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.id = :id";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> findByName(String name) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.name = :name";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryStr, Product.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product origin = findById(product.getId());
            origin.setName(product.getName());
            origin.setPrice(product.getPrice());
            origin.setDescription(product.getDescription());
            origin.setProducer(product.getProducer());
            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = BaseRepository.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(findById(id));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
