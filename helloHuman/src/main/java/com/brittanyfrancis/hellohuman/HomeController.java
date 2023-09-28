package com.brittanyfrancis.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	public String human(@RequestParam(value="name", required=false)String firstName, @RequestParam(value="secondname", required=false)String lastName, @RequestParam(value="times", required=false)Integer num) {
		if(num==null) {
			if(firstName==null&&lastName==null) {
				return "Hello Human";	
			}
			else if(firstName==null) {
				return "Hello Mr./Ms. " + lastName;
			}else if(lastName==null) {
				return "Hello " + firstName;
			}else {
			return "Hello " + firstName +" " +lastName;}
			
		}else {
			
			if(firstName==null&&lastName==null) {
				return "Hello Human ".repeat(num);	
			}
			else if(firstName==null) {
				return ("Hello Mr./Ms. " + lastName+ " ").repeat(num);
			}else if(lastName==null) {
				return ("Hello " + firstName +" ").repeat(num);
			}else {
			return ("Hello " + firstName +" " +lastName+ " ").repeat(num);}
		}

		
		
	}
}
