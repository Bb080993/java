package com.brittanyfrancis.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brittanyfrancis.burgertracker.models.Burger;
import com.brittanyfrancis.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	   private final BurgerRepository burgerRepository;
	   
	   
	   
	   //constructor 
	    public BurgerService(BurgerRepository burgerRepository) {
	        this.burgerRepository = burgerRepository;
	    }
	    // returns all the burgers
	    public List<Burger> allBurgers() {
	        return burgerRepository.findAll();
	    }
//	    // creates a burger
	    public Burger createBurger(Burger newBurger) {
	    	return burgerRepository.save(newBurger);
	    }
		
	    
	    // retrieves one burger
	    public Burger findBurger(Long id) {
	        Optional<Burger> optionalBurger = burgerRepository.findById(id);
	      //another way to return one burger
		  //return burger.isPresent() ? burger.get() : null;
	      //Ternary operator^
	        if(optionalBurger.isPresent()) {
	            return optionalBurger.get();
	        } else {
	            return null;
	        }
	    }
	    
//	    
	    //update a burger
	    public Burger updateBurger(Burger b) {
	    	return burgerRepository.save(b);
	    }
//		
	    //delete burger...it is void so don't return anything
	    public void deleteBurger(Long id) {
	    	burgerRepository.deleteById(id);
	    }

}

