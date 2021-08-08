package com.example.model.repository.security;

import com.example.model.entity.AppUser;
import com.example.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
List<UserRole> findByAppUser(AppUser appUser);
}
