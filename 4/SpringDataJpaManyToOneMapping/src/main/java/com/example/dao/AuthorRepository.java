package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Author;
import com.example.entity.Book;

public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
