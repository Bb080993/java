package com.brittanyfrancis.safeTravels.controllers;

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

import com.brittanyfrancis.safeTravels.models.Expense;
import com.brittanyfrancis.safeTravels.services.ExpenseService;

import jakarta.validation.Valid;


@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	
	@RequestMapping("/expenses")
	public String index(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allExpenses=expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		
		return "index.jsp";
	}
	//form to create
		@PostMapping("/create")
		public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
			
			if(result.hasErrors()) {
				return "index.jsp";}
			else {
				expenseService.createExpense(expense);
				return "redirect:/expenses";
			}
		
		}
		//Get one
		@RequestMapping("/expense/{id}")
		public String viewOne(@PathVariable("id")Long id, Model model) {
			Expense oneExpense=expenseService.findExpense(id);
			model.addAttribute("oneExpense", oneExpense);
			return "one.jsp";
		}
		//Edit page
		@RequestMapping("/edit/{id}")
		public String editPage(@PathVariable("id")Long id, Model model) {
			Expense oneExpense=expenseService.findExpense(id);
			model.addAttribute("oneExpense", oneExpense);
			return "edit.jsp";
		}
		
		//Edit form
		@PutMapping("update/{id}")
		public String editForm(@Valid @ModelAttribute("oneExpense") Expense oneExpense, BindingResult result, Model model) {
			if(result.hasErrors()) {
				model.addAttribute("oneExpense", oneExpense);
				return "edit.jsp";}
			else {
				expenseService.updateExpense(oneExpense);
				return "redirect:/expenses";
			}
		
		}
		
		//delete
		@DeleteMapping("/delete/{id}")
		public String delete(@PathVariable("id")Long id) {
			
			expenseService.deleteExpense(id);
			return "redirect:/expenses";
		}

}
