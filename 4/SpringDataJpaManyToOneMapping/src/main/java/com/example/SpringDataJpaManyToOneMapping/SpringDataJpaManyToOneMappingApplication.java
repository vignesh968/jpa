package com.example.SpringDataJpaManyToOneMapping;

import org.hibernate.mapping.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.service.LibraryService;

@SpringBootApplication
public class SpringDataJpaManyToOneMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaManyToOneMappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(LibraryService service) {
	    return args -> {
	        Author author = new Author("John");
	        author = service.saveAuthor(author);

	        Book book1 = new Book("Core Java", "Technology");
	        book1.setAuthor(author);
	        book1 = service.saveBook(book1);

	        Book book2 = new Book("SpringBoot", "Technology");
	        book2.setAuthor(author);
	        book2 = service.saveBook(book2);

	        // Get all authors
	        System.out.println("All Authors:");
	        java.util.List<Author> allAuthors = service.getAllAuthors();
	        allAuthors.forEach(System.out::println);

	        // Get book by given book ID
	        int bookIdToRetrieve = 2;
	        Author retrievedBook = service.getBookByBookId(bookIdToRetrieve);
	        System.out.println("Book with ID " + bookIdToRetrieve + ": " + retrievedBook);

	        // Get all books of given author ID
	        int authorIdToRetrieve = 1;
	        java.util.List<Book> booksByAuthor = service.getAllBooksByAuthorId(authorIdToRetrieve);
	        System.out.println("Books by Author ID " + authorIdToRetrieve + ":");
	        booksByAuthor.forEach(System.out::println);
	    };
	}

}
