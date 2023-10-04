package com.brittanyfrancis.bookclub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brittanyfrancis.bookclub.models.Book;
import com.brittanyfrancis.bookclub.models.LoginUser;
import com.brittanyfrancis.bookclub.models.User;
import com.brittanyfrancis.bookclub.services.BookService;
import com.brittanyfrancis.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;



@Controller
public class MainController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		
		
		return "index.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model, HttpSession session) {
		//make new user
		User createUser= userService.register(newUser, result);
		//reject if errors
		if(result.hasErrors()){
			 model.addAttribute("newLogin", new LoginUser());
			 //return jsp if errors w/ new LoginUser
			return "index.jsp";
		}else {
			//save id to session
			session.setAttribute("userId", createUser.getId());
			
			//if no errors, redirect to books
			
			return "redirect:/books";
		}
			
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model, HttpSession session) {
		//make new user
		User foundUser= userService.login(newLogin, result);
		
		//reject if errors
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			//return jsp if errors w/ new User
			return "index.jsp";
		}else {
			//save id to session
			session.setAttribute("userId", foundUser.getId());
			//if no errors, redirect to books
			return "redirect:/books";
		}
	
	}
	@RequestMapping("/books")
	public String books(Model model, HttpSession session) {
		//if no one is logged in
    	if(session.getAttribute("userId")==null) {
    		
    		return "redirect:/";
    	}
		//allows you to user logged in users info on page
    	Long userId= (Long) session.getAttribute("userId");
    	model.addAttribute("loggedInUser", userService.findById(userId));
    	
    	List<Book> allBooks= bookService.allBooks();
    	model.addAttribute("allBooks", allBooks);
		return "books.jsp";
	}
	
	@RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
    		
    		return "redirect:/";
    	}
		Long userId= (Long) session.getAttribute("userId");
    	model.addAttribute("loggedInUser", userService.findById(userId));

		List<Book> allBooks=bookService.allBooks();
		model.addAttribute("allBooks", allBooks);
		
		return "createBook.jsp";
	}
	
	@PostMapping("/createBook")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "createBook.jsp";}
		else {
			bookService.createBook(book);
		return "redirect:/books";
			}
		}
	@RequestMapping("/books/{id}")
	public String oneBook(@PathVariable("id")Long id, Model model, HttpSession session) {
if(session.getAttribute("userId")==null) {
    		
    		return "redirect:/";
    	}
		Long userId= (Long) session.getAttribute("userId");
    	model.addAttribute("userId", userId);
		
		Book oneBook= bookService.findBook(id);
		model.addAttribute("oneBook", oneBook);
		return "oneBook.jsp";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		
		bookService.deleteBook(id);
		return "redirect:/books";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
if(session.getAttribute("userId")==null) {
    		
    		return "redirect:/";
    	}
		Book oneBook= bookService.findBook(id);
		model.addAttribute("oneBook", oneBook);
		return "edit.jsp";
	}
	@PutMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute("oneBook") Book oneBook, BindingResult result, Model model, HttpSession session) {
if(session.getAttribute("userId")==null) {
    		
    		return "redirect:/";
    	}
		if(result.hasErrors()) {
			return "edit.jsp";
		}else {
		bookService.updateBook(oneBook);
		return "redirect:/books";
		}
	}
	}
