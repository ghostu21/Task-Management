package com.taskmanagement.User.Service.dto;

import com.taskmanagement.User.Service.constant.UserRole;

public class CreateUserRequestTO {

	
	private String email;
	private String password;


	private String name;
	
	private UserRole role;


	// Getters and setters



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



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}



}
