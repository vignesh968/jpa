package com.example.SpringDataJPAManyToManyMapping.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringDataJPAManyToManyMapping.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
