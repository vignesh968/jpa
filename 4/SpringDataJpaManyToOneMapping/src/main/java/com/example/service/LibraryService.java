package com.example.service;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.dao.AuthorRepository;
import com.example.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Author saveAuthor(Author author) {
        
        return authorRepository.save(author);
    }

    public Book saveBook(Book book) {
        
        return bookRepository.saveAll(book);
    }

    public List<Author> getAllAuthors() {
        
        return authorRepository.findAll();
    }

    public Author getBookByBookId(int bookId) {
        
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<Book> getAllBooksByAuthorId(int authorId) {
        
        return bookRepository.findAllBooksByAuthorId(authorId);
    }
}

