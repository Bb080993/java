package com.brittanyfrancis.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping(value="/fortune", method=RequestMethod.POST)
	public String fortune(@RequestParam(value="number")int number, @RequestParam(value="city") String city, @RequestParam(value="name") String name, @RequestParam(value="hobby") String hobby, @RequestParam(value="livingThing") String livingThing, @RequestParam(value="nice") String nice, HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("nice", nice);
		
		return "redirect:/omikuji/show";
	}
	@RequestMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}

}
