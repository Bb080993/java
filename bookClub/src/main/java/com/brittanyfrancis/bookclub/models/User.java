package com.brittanyfrancis.bookclub.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {

	
	//table columns
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Please enter your name")
	@Size(min=1, max=70, message="Name must be a minimum of 1 character and maximum of 70 characters")
	private String name;
	
	@NotEmpty(message="Please enter your email")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message="Please enter a password")
	@Size(min=8, max=255, message="Please enter a password with a minimum of 8 characters and a maximum of 255 characters.")
	private String password;
	
	@Transient
	@NotEmpty(message="Please enter your confirmed password")
	@Size(min=8, max=255, message="Please enter a confirmed password with a minimum of 8 characters and a maximum of 255 characters.")
	private String confirm;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Book> books;

	//constructors
	public User() {
		
	}

	public User(
			 String name,
			 String email,
			 String password,
			 String confirm) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}

	//getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
