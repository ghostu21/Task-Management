package com.taskmanagement.Submission.Service.service;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.taskmanagement.Submission.Service.dto.TaskDTO;



@FeignClient (name="Task-Service", url="http://localhost:5002")
public interface TaskService {
	
	@GetMapping("/api/task/{id}")
	public TaskDTO getTaskId(@PathVariable Long id,
			@RequestHeader("Authorization") String jwt) throws Exception;
	
	@PutMapping("/api/tasks/{id}/complete")
	public TaskDTO completeTask(
	@PathVariable Long id) throws Exception;

}
