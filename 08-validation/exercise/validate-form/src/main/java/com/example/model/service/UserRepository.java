package com.example.model.service;

import com.example.model.entity.User;
import com.example.model.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepository implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
