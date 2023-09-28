package com.brittanyfrancis.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burgers")
public class Burger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Please enter a burger name")
	@Size(min=1, max=255, message="Must be greater than 1 character and less than 255 characters")
	private String burgerName;
	
	@NotEmpty(message="Please enter a restaurant name")
	@Size(min=1, max=255, message="Must be greater than 1 character and less than 255 characters")
	private String restaurantName;
	
	@NotNull(message="Please enter a rating between 1 and 5")
	@Min(value=1, message="Must be greater than 0 and less than 6 characters")
	@Max(value=5, message="Must be greater than 0 and less than 6 characters")
	private Long rating;
	
	@NotEmpty(message="Please enter a note")
	@Size(min=1, max=255, message="Must be greater than 1 character and less than 255 characters")
	private String notes;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	//Constructors
	  public Burger() {
	    }
	  
	  public Burger(String burgerName, String restaurantName, Long rating, String notes) {
	        this.burgerName = burgerName;
	        this.restaurantName = restaurantName;
	        this.rating = rating;
	        this.notes = notes;
	    }
	    
	    
	    //Getters and Setters
	 
		
	   
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBurgerName() {
			return burgerName;
		}
		public void setBurgerName(String burgerName) {
			this.burgerName = burgerName;
		}
		public String getRestaurantName() {
			return restaurantName;
		}
		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}
		public Long getRating() {
			return rating;
		}
		public void setRating(Long rating) {
			this.rating = rating;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		@PrePersist
		    protected void onCreate(){
		        this.createdAt = new Date();
		    }
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }

	
	
	
	

}
