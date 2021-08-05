package com.example.model.repository.division;

import com.example.model.entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDivisionRepository extends JpaRepository<Division,Long> {
    List<Division> findAll();
}
