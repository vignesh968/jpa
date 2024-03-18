package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Author;
import com.example.entity.Book;

public interface BookRepository extends JpaRepository<Author, Integer> {
	Book findByBookId(int BookId);
	List<Book> findAllBooksByAuthorId(int authorId);
	Book saveAll(Book book);

}
