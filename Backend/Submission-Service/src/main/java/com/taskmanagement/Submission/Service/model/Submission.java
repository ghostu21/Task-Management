package com.taskmanagement.Submission.Service.model;

import java.util.Date;

import jakarta.persistence.Entity;
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
	
	private Long id;
	
	private Long taskId;
	
	private String githubLink;
	
	private String status="PENDING";
	
	private Date submissionTime;

}
