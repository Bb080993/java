package com.brittanyfrancis.jpademo.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brittanyfrancis.jpademo.models.Book;
import com.brittanyfrancis.jpademo.services.BookService;


@Controller
public class BookController {
	@Autowired
	BookService bookservice;
	
	@RequestMapping("/books/{id}")
	public String oneBook(Model model, @PathVariable("id") Long id) {
		
		System.out.println(id);
		Book book=bookservice.findBook(id);
		
		model.addAttribute("book", book);
		
		
		System.out.println(book);
		return "show.jsp";
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		
		
		ArrayList<Book> books=bookservice.allBooks();
		
		model.addAttribute("books", books);
		return "index.jsp";
	}
	

}
