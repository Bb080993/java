package com.brittanyfrancis.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
			
			
	    	// If the count is not already in session
			if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
				session.setAttribute("count", 0);
			}
			else {
			// increment the count by 1 using getAttribute and setAttribute
				int viewCount=(int) session.getAttribute("count");
				viewCount++;
				session.setAttribute("count", viewCount);
			}
			
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "countPage.jsp";
		
	}
	@RequestMapping("/clear")
	public String clear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	

}
