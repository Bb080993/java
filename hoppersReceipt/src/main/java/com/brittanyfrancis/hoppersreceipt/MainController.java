package com.brittanyfrancis.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(Model model){
	 
	    String name = "Brittany Francis";
	    String itemName = "Chocolate Chip Cookie";
	    double price = 1.25;
	    String description = "1 amazing cookie!";
	    String vendor = "Bakery on 5th Ave";
	    
	    model.addAttribute("name", name);
	    model.addAttribute("itemName", itemName);
	    model.addAttribute("price", price);
	    model.addAttribute("description", description);
	    model.addAttribute("vendor", vendor);

		return "hopper.jsp";
		
	}

}
