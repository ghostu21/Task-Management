package com.taskmanagement.Submission.Service.model;

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
@Table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Submission {
	

	@Id
	@GeneratedValue (strategy = GenerationType. AUTO)
	private Long id;
	
	@Column(name = "task_id", nullable = false)
	private Long taskId;
	
	@Column(name = "user_id", nullable = false)
	private Long userId;
	
	@Column(name = "github_link", nullable = false)
	private String githubLink;
	
	@Column(name = "status", nullable = false)
	private String status="PENDING";
	
	@Column(name = "submission_time", nullable = false)
	private Date submissionTime;

}
