package com.brittanyfrancis.displaydate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping ("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping ("/date")
	public String date(Model model) {
//		LocalDate todaysDate=LocalDate.now();
		LocalDateTime dateTime = LocalDateTime.now();   
	    DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("E, MMM dd, yyyy");
	    String todaysDate = dateTime.format(formattedDate);
		
		model.addAttribute("todaysDate", todaysDate);
		return "date.jsp";
	}
	
	@RequestMapping ("/time")
	public String time(Model model) {
//		LocalTime time=LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();   
	    DateTimeFormatter formattedTime = DateTimeFormatter.ofPattern("hh:mm a");
	    String time = dateTime.format(formattedTime); 
		
		model.addAttribute("time", time);
		return "time.jsp";
	}

}
