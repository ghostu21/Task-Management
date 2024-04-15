package com.taskmanagement.User.Service.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "full_name", nullable = false)
	private String fullName;
	
	@Column(name = "role", nullable = false)
	 private String role;
	 
	 @Column(name = "created_time", nullable = false)
		private Date createdTime;

		@Column(name = "last_modified_time", nullable = false)
		private Date lastModifiedTime;
	 

}
