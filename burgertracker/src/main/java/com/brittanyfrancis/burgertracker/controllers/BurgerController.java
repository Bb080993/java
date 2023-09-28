package com.brittanyfrancis.burgertracker.controllers;

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

import com.brittanyfrancis.burgertracker.models.Burger;
import com.brittanyfrancis.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	@Autowired
	private BurgerService burgerService;
	
	//Get all
	@RequestMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		
		List<Burger> allBurgers=burgerService.allBurgers();
		model.addAttribute("allBurgers", allBurgers);
	
		
		return "index.jsp";
	}
	//form to create
	@PostMapping("/create")
	public String addBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
		
		if(result.hasErrors()) {
			return "index.jsp";}
		else {
			burgerService.createBurger(burger);
			return "redirect:/";
		}
	
	}
	//Get one
	@RequestMapping("/burger/{id}")
	public String viewOne(@PathVariable("id")Long id, Model model) {
		Burger oneBurger=burgerService.findBurger(id);
		model.addAttribute("oneBurger", oneBurger);
		return "one.jsp";
	}
	
	//Edit page
	@RequestMapping("/edit/{id}")
	public String editPage(@PathVariable("id")Long id, Model model) {
		Burger oneBurger=burgerService.findBurger(id);
		model.addAttribute("oneBurger", oneBurger);
		return "edit.jsp";
	}
	//Edit form
	@PutMapping("update/{id}")
	public String editForm(@Valid @ModelAttribute("oneBurger") Burger oneBurger, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("oneBurger", oneBurger);
			return "edit.jsp";}
		else {
			burgerService.updateBurger(oneBurger);
			return "redirect:/";
		}
	
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id, Model model) {
		
		burgerService.deleteBurger(id);
		return "redirect:/";
	}
}
