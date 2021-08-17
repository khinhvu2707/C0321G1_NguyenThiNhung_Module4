package com.example.model.repository;

import com.example.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
}
