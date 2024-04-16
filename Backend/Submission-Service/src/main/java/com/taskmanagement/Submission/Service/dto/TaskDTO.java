package com.taskmanagement.Submission.Service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taskmanagement.Submission.Service.constant.TaskStatus;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {
	
	

	private Long id;

	private String title;
	

	private String description;
	

	private String image;

	private Long assignedUserId;
	

	private List<String>tags=new ArrayList<>();
	

	private TaskStatus status;
	

	private Date deadline;
	

	private Date createdTime;

}
