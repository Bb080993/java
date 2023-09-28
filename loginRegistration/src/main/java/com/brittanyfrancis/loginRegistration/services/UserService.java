package com.brittanyfrancis.loginRegistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.brittanyfrancis.loginRegistration.models.LoginUser;
import com.brittanyfrancis.loginRegistration.models.User;
import com.brittanyfrancis.loginRegistration.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    //register a new user and validate
    public User register(User newUser, BindingResult result) {
    	// Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
		    result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
		}
    	//check to see if email is already in db
    	Optional <User> foundUser= userRepo.findByEmail(newUser.getEmail());
    		if(foundUser.isPresent()) {
    			result.rejectValue("email", "Taken", "Email is already taken");
    		}
    		//check to see if userName is alpha
    		String isAlpha= newUser.getUserName();
    		if(!isAlpha.matches("[a-zA-Z]+")) {
    			result.rejectValue("userName", "NotAlpha", "Must be only letters");
    		}
    	//if there are any errors, reject
    	if(result.hasErrors()) {
    		
    		return null;}
        // Reject if email is taken (present in database)
    		 Optional<User> optionalEmail = userRepo.findByEmail(newUser.getEmail());  
    		 if(optionalEmail.isPresent()) {
    		 return null;
    		 }else {
    			 String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    			 newUser.setPassword(hashed);//set password in database to hashed pw
    			 return userRepo.save(newUser);//save new user in db
    		 }
    }
    
    //find user by id
    public User findById(Long id) {
    	Optional<User> findUser= userRepo.findById(id);
    	
    	return findUser.isPresent() ? findUser.get():null;
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
        //check to see if user exists
    	Optional<User> findTheUser = userRepo.findByEmail(newLoginObject.getEmail()); //login object from form gets passed in 
		 if(findTheUser.isEmpty()) {
			 result.rejectValue("email", "Invalid", "Invalid login credentials");
		 return null;}else {//if user is found
			 User userInDb= findTheUser.get();
			 
			 // Reject if BCrypt password match fails
			 if(!BCrypt.checkpw(newLoginObject.getPassword(), userInDb.getPassword())) {
				 result.rejectValue("password", "Invalid", "Invalid login credentials");
				 return null;
			 }else {
				 return userInDb;
			 }
			 
		 }
       
    }
}