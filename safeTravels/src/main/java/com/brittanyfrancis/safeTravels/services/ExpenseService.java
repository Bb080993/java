package com.brittanyfrancis.safeTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brittanyfrancis.safeTravels.models.Expense;
import com.brittanyfrancis.safeTravels.repositories.ExpenseRepository;



@Service
public class ExpenseService {
	

		   private final ExpenseRepository expenseRepository;
		   
		   
		   
		   //constructor 
		    public ExpenseService(ExpenseRepository expenseRepository) {
		        this.expenseRepository = expenseRepository;
		    }
		    // returns all the expenses
		    public List<Expense> allExpenses() {
		        return expenseRepository.findAll();
		    }
//		    // creates a expense
		    public Expense createExpense(Expense newExpense) {
		    	return expenseRepository.save(newExpense);
		    }
			
		    
		    // retrieves one expense
		    public Expense findExpense(Long id) {
		        Optional<Expense> optionalExpense = expenseRepository.findById(id);
		      //another way to return one expense
			  //return expense.isPresent() ? expense.get() : null;
		      //Ternary operator^
		        if(optionalExpense.isPresent()) {
		            return optionalExpense.get();
		        } else {
		            return null;
		        }
		    }
		    
//		    
		    //update a Expense
		    public Expense updateExpense(Expense b) {
		    	return expenseRepository.save(b);
		    }
//			
		    //delete expense...it is void so don't return anything
		    public void deleteExpense(Long id) {
		    	expenseRepository.deleteById(id);
		    }

	}


