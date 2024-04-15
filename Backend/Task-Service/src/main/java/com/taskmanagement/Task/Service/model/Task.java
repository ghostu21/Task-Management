package com.taskmanagement.Task.Service.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taskmanagement.Task.Service.constant.TaskStatus;

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
@Table(name="tasks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {
	
	@Id
	@GeneratedValue (strategy = GenerationType. AUTO)
	private Long id;
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "user_id", nullable = false)
	private Long assignedUserId;
	
	@Column(name = "tags")
	private List<String>tags=new ArrayList<>();
	
	@Column(name = "status", nullable = false)
	private TaskStatus status;
	
	@Column(name = "deadline")
	private Date deadline;
	
	@Column(name = "created_time")
	private Date createdTime;
	
	

}
