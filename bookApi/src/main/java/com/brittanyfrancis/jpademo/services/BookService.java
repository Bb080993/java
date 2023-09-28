package com.brittanyfrancis.jpademo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brittanyfrancis.jpademo.models.Book;
import com.brittanyfrancis.jpademo.repositories.BookRepository;

@Service
public class BookService {
	   private final BookRepository bookRepository;
	   
	   
	    
	    public BookService(BookRepository bookRepository) {
	        this.bookRepository = bookRepository;
	    }
	    // returns all the books
	    public ArrayList<Book> allBooks() {
	        return bookRepository.findAll();
	    }
	    // creates a book
	    public Book createBook(Book b) {
	        return bookRepository.save(b);
	    }
	    // retrieves a book
	    public Book findBook(Long id) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    //update a book
	    public Book updateBook(Book b) {
	    	return bookRepository.save(b);
	    }
		
	    //delete book...it is void so don't return anything
	    public void deleteBook(Long id) {
	    	 bookRepository.deleteById(id);
	    }

}
