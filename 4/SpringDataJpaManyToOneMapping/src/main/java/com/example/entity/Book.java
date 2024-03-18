package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private int bookId;
private String bookName; private String category:
@ManyToOne (fetch = FetchType.EAGER)
@JoinColumn (name = "authorId")
private Author author;
public Book() {};
public Book (String bookName, String category) {
super () ;
this.bookName = bookName;
this. category = category;
}
public void setAuthor(Author author2) {
	// TODO Auto-generated method stub
	
}
}
