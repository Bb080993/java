package com.brittanyfrancis.dojosAndNinjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brittanyfrancis.dojosAndNinjas.models.Dojo;
import com.brittanyfrancis.dojosAndNinjas.models.Ninja;
import com.brittanyfrancis.dojosAndNinjas.services.DojoService;
import com.brittanyfrancis.dojosAndNinjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	
	@Autowired
	private NinjaService ninjaService;
	
	@RequestMapping("/")
	public String home(Model model) {
		List<Dojo> allDojos= dojoService.getAllDojos();
		model.addAttribute("allDojos", allDojos);
		return "index.jsp";
	}
	
	@RequestMapping("/dojo/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		
		
		return "createDojo.jsp";
	}
	@PostMapping("/create/dojo")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "createDojo.jsp";
		}else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/ninja/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos= dojoService.getAllDojos();
		model.addAttribute("allDojos", allDojos);
		
		
		return "createNinja.jsp";
	}
	@PostMapping("/create/ninja")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "createNinja.jsp";
		}else {
			ninjaService.createNinja(ninja);
			return "redirect:/";
		}
	}
	@RequestMapping("/dojo/{id}")
	public String oneDojo(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("oneDojo", dojoService.getDojo(id));
		
		return "oneDojo.jsp";
	}

}
