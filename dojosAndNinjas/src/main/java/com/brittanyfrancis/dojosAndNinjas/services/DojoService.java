package com.brittanyfrancis.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brittanyfrancis.dojosAndNinjas.models.Dojo;
import com.brittanyfrancis.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	   private final DojoRepository dojoRepository;
	    
	    public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }
	    //create one dojo
	    public Dojo createDojo(Dojo dojo) {
	    	return dojoRepository.save(dojo);
	    }
	    //get all dojos
	    public List<Dojo> getAllDojos(){
	    	return dojoRepository.findAll();
	    }
	    //get one dojo
	    
	   public Dojo getDojo(Long id) {
		   
		   Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		   if(optionalDojo.isPresent()) {
	            return optionalDojo.get();
	        } else {
	            return null;
	        }

	   }


}
