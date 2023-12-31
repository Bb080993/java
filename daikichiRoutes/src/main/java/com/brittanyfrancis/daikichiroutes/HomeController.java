package com.brittanyfrancis.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("daikichi")
public class HomeController {
	@RequestMapping("")
	public String home() {
		return "Welcome!";
	}
	@RequestMapping("/today")
	public String today(){
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
		}
	@RequestMapping("/travel/{location}")
	public String travel(@PathVariable("location") String locationName){
		return "Congratulations! You will soon travel to " + locationName + "!";
	}
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number")int num){
		if(num%2==0) {
			return "You will take a grand journey in the near future, but be wary of tempting offers.";}
		else {return "You have enjoyed the fruits of your labor but now is a great time to spend with friends and family.";}
		}
	}


