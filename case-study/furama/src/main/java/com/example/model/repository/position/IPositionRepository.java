package com.example.model.repository.position;

import com.example.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPositionRepository extends JpaRepository<Position,Long> {
    List<Position> findBy();
}
