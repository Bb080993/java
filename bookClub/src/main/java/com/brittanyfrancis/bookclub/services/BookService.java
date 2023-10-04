package com.brittanyfrancis.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brittanyfrancis.bookclub.models.Book;
import com.brittanyfrancis.bookclub.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	 // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
//    // creates a book
    public Book createBook(Book newBook ) {

//    	newBook.setUser(null);
    	return bookRepository.save(newBook);
    }
	
    
    // retrieves one book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
      
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
//    
    //update a book
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
//	
    //delete book...it is void so don't return anything
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
}
