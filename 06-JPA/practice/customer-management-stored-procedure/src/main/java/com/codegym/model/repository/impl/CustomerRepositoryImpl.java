package com.codegym.model.repository.impl;

import com.codegym.model.bean.Customer;
import com.codegym.model.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    @Override
    public void insertWithStoredProcedure(Customer customer) {
        String sql = "CALL Insert_Customer(:firstName, :lastName)";
        EntityTransaction transaction = BaseRepository.entityManager.getTransaction();
        transaction.begin();
        Query query = BaseRepository.entityManager.createNativeQuery(sql);
        query.setParameter("firstName", customer.getFirstName());
        query.setParameter("lastName", customer.getLastName());
        query.executeUpdate();
        transaction.commit();
    }
}
