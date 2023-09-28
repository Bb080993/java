package com.brittanyfrancis.dojosAndNinjas.services;

import org.springframework.stereotype.Service;

import com.brittanyfrancis.dojosAndNinjas.models.Ninja;
import com.brittanyfrancis.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	   
	   
	   
	   //constructor 
	    public NinjaService(NinjaRepository ninjaRepository) {
	        this.ninjaRepository = ninjaRepository;
	    }
	    
	    public Ninja createNinja(Ninja ninja) {
	    	return ninjaRepository.save(ninja);
	    }

}
