package com.brittanyfrancis.bookclub.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	
	@NotEmpty(message="Please enter your email")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Please enter a password")
	@Size(min=8, max=255, message="Please enter a password with a minimum of 8 characters and a maximum of 255 characters.")
	private String password;
	
	
	//constructors
	public LoginUser() {
		
		
	}
	public LoginUser(String email, String password) {
		this.email=email;
		this.password=password;
	}
	//getters and setters
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
	
	
}
