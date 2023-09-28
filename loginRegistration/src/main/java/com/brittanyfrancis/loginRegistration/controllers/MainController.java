package com.brittanyfrancis.loginRegistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brittanyfrancis.loginRegistration.models.LoginUser;
import com.brittanyfrancis.loginRegistration.models.User;
import com.brittanyfrancis.loginRegistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	 // Add once service is implemented:
     @Autowired
     private UserService userService;
    
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        //Make a new User
    	User createUser= userService.register(newUser, result);
        
        //Extra validations
        if(result.hasErrors()) {
           
            model.addAttribute("newLogin", new LoginUser());
            return "login.jsp";
        }else {
        	session.setAttribute("userId", createUser.getId());
        	return "redirect:/home";	
        }
       
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        //perform validations first
    	
        User foundUser= userService.login(newLogin, result);
        
        if(result.hasErrors()) {
        	model.addAttribute("newUser", new User());
        	return "login.jsp";
        }else {
        	session.setAttribute("userId", foundUser.getId());
        	return "redirect:/home";	

        }
   
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
    	//if no one is logged in
    	if(session.getAttribute("userId")==null) {
    		
    		return "redirect:/";
    	}
    	
    	
    	Long userId= (Long) session.getAttribute("userId");
    	model.addAttribute("loggedInUser", userService.findById(userId));
    	return "home.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }

}
